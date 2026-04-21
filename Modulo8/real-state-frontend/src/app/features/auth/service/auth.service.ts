import { Injectable, signal, computed } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap, catchError, throwError } from 'rxjs';
import { User, LoginRequest, LoginResponse, RegisterRequest, AuthState } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'http://localhost:8080/api/auth';
  
  // Signals para el estado de autenticación
  private _authState = signal<AuthState>({
    user: null,
    token: null,
    isAuthenticated: false,
    loading: false,
    error: null
  });

  // Computed signals para acceder al estado
  readonly authState = this._authState.asReadonly();
  readonly user = computed(() => this._authState().user);
  readonly token = computed(() => this._authState().token);
  readonly isAuthenticated = computed(() => this._authState().isAuthenticated);
  readonly loading = computed(() => this._authState().loading);
  readonly error = computed(() => this._authState().error);

  constructor(private http: HttpClient) {
    // Intentar restaurar la sesión desde localStorage
    this.restoreSession();
  }

  // Login
  login(credentials: LoginRequest): Observable<LoginResponse> {
    this.setLoading(true);
    this.clearError();

    return this.http.post<LoginResponse>(`${this.baseUrl}/login`, credentials).pipe(
      tap(response => {
        localStorage.setItem('access_token', response.access_token);
        localStorage.setItem('user', JSON.stringify(response.username));
        this.handleSuccessfulAuth(response);
      }),
      catchError(error => {
        this.handleAuthError(error);
        return throwError(() => error);
      })
    );
  }

  // Registro
  register(userData: RegisterRequest): Observable<User> {
    this.setLoading(true);
    this.clearError();

    return this.http.post<User>(`${this.baseUrl}/register`, userData).pipe(
      tap(user => {
        this.setLoading(false);
        this.clearError();
      }),
      catchError(error => {
        this.handleAuthError(error);
        return throwError(() => error);
      })
    );
  }

  // Logout
  logout(): void {
    // Opcional: enviar request al backend para invalidar el token
    this.http.post(`${this.baseUrl}/logout`, {}).subscribe({
      error: () => {
        // Si falla el logout en el backend, continuamos con el logout local
      }
    });

    this.clearAuthState();
    this.redirectToLogin();
  }

  // Verificar si el token es válido
  isTokenValid(): boolean {
    const token = this.token();
    if (!token) return false;

    try {
      // Decodificar el token JWT (solo para verificar expiración)
      const payload = JSON.parse(atob(token.split('.')[1]));
      const currentTime = Date.now() / 1000;
      
      return payload.exp > currentTime;
    } catch {
      return false;
    }
  }

  // Refrescar token
  refreshToken(): Observable<LoginResponse> {
    const refreshToken = localStorage.getItem('refreshToken');
    if (!refreshToken) {
      return throwError(() => new Error('No refresh token available'));
    }

    return this.http.post<LoginResponse>(`${this.baseUrl}/refresh`, { refreshToken }).pipe(
      tap(response => {
        this.handleSuccessfulAuth(response);
      }),
      catchError(error => {
        this.handleAuthError(error);
        return throwError(() => error);
      })
    );
  }

  // Métodos privados para manejar el estado
  private handleSuccessfulAuth(response: LoginResponse): void {
    const newState: AuthState = {
      user: response.username,
      token: response.access_token,
      isAuthenticated: true,
      loading: false,
      error: null
    };

    this._authState.set(newState);

    // Guardar en localStorage
    localStorage.setItem('access_token', response.access_token);
    localStorage.setItem('user', JSON.stringify(response.username));
  }

  private handleAuthError(error: any): void {
    let errorMessage = 'Error de autenticación';
    
    if (error.error && error.error.message) {
      errorMessage = error.error.message;
    } else if (error.message) {
      errorMessage = error.message;
    }

    const newState: AuthState = {
      ...this._authState(),
      loading: false,
      error: errorMessage
    };

    this._authState.set(newState);
  }

  private setLoading(loading: boolean): void {
    const newState: AuthState = {
      ...this._authState(),
      loading
    };
    this._authState.set(newState);
  }

  private clearError(): void {
    const newState: AuthState = {
      ...this._authState(),
      error: null
    };
    this._authState.set(newState);
  }

  private clearAuthState(): void {
    const newState: AuthState = {
      user: null,
      token: null,
      isAuthenticated: false,
      loading: false,
      error: null
    };

    this._authState.set(newState);

    // Limpiar localStorage
    localStorage.removeItem('access_token');
    localStorage.removeItem('refreshToken');
    localStorage.removeItem('user');
  }

  private restoreSession(): void {
    const token = localStorage.getItem('access_token');
    const userStr = localStorage.getItem('user');

    if (token && userStr) {
      try {
        const user = JSON.parse(userStr);
        if (this.isTokenValid()) {
          const restoredState: AuthState = {
            user,
            token,
            isAuthenticated: true,
            loading: false,
            error: null
          };
          this._authState.set(restoredState);
        } else {
          this.clearAuthState();
        }
      } catch {
        this.clearAuthState();
      }
    }
  }

  private redirectToLogin(): void {
    // Redirigir al login (esto se manejará desde el componente)
    window.location.href = '/auth/login';
  }
}
