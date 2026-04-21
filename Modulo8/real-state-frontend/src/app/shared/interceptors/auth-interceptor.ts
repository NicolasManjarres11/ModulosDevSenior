import { HttpErrorResponse, HttpEvent, HttpEventType, HttpHandler, HttpHandlerFn, HttpInterceptor, HttpRequest, HttpResponse, HttpStatusCode } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { catchError, finalize, Observable, tap, throwError } from "rxjs";

@Injectable()
export class AuthInterceptor implements HttpInterceptor{

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        
        const started = Date.now();
        let request = req;

        return next.handle(request).pipe(
            tap((event: HttpEvent<any>) => { //
                if(event.type === HttpEventType.Response) {
                    console.log("event", event);
                }   
        }),
            catchError((error : any) => {
                console.log("error", error);
                return throwError(() => error);
            }),
            finalize(() => {
                const elapsed = Date.now() - started;
                console.log(`Request for ${req.urlWithParams} took ${elapsed}ms`);
            })
        );
    }

}

export function authInterceptor(req: HttpRequest<any>, next: HttpHandlerFn): Observable<HttpEvent<any>>{

    const started = Date.now();
    let request = req;

    console.log(`Event for ${req.urlWithParams} started`);
    console.log(`[HTTP SUCCESS] Respuesta recibida de: ${request.url}`);

    const token = localStorage.getItem('access_token');

    if(token){
        request = req.clone({
            setHeaders:{
              Authorization: `Bearer ${token}`  
            }
        });
    }
    

    return next(request).pipe(
        tap((event: HttpEvent<any>) => { //
            if(event.type === HttpEventType.Response) {
                console.log("event", event);
                console.log(`[HTTP SUCCESS] Respuesta recibida de: ${request.url}`, event);

            }   
    }),
        catchError((error : any) => {
            console.log("error", error);
            console.log(`[HTTP ERROR] Respuesta recibida de: ${request.url}`, error.message);

            return throwError(() => error);
        }),
        finalize(() => {
            const elapsed = Date.now() - started;
            console.log(`[HTTP SUCCESS] Request for ${req.urlWithParams} took ${elapsed}ms`);
        })
    );

}

export function logginInterceptor(
    req: HttpRequest<any>,
     next: HttpHandlerFn): 
     Observable<HttpEvent<any>>{

        const startTime = Date.now();

        console.log(`[HTTP START] Petición a: ${req.url}`);
        

    return next(req)
        .pipe(
            tap(event => {
                if(event.type === HttpEventType.Response){
                    console.log(`[HTTP SUCCESS] Respuesta recibida de: ${req.url}`, event);
                    
                }
            }),
            catchError( (error: HttpErrorResponse) => {

                console.log(`[HTTP ERROR] Respuesta recibida de: %${req.url}`, error);
                return throwError(() => {error})
            }),
            finalize(() => {
                const duration = Date.now() - startTime;
                console.log(`[HTTP END] Peticion a: ${req.url} completada en ${duration} ms`,);
                
            })
        );
}

export function errorInteceptor(
    req: HttpRequest<any>,
     next: HttpHandlerFn): 
     Observable<HttpEvent<any>>{

        const router = inject(Router);
        
        return next(req)
        .pipe(
            catchError((error: HttpErrorResponse) => {


                switch (error.status) {
                    case HttpStatusCode.NotFound:
                        router.navigate(['/notfound']);
                        break;
                    case HttpStatusCode.Forbidden:
                    case HttpStatusCode.Unauthorized:
                        router.navigate(['/login']);
                        break;
                
                    default:
                        console.error(`ERROR EN LA LLAMADA AL BACKEND`, error);
                }
                return throwError(() => error)
            })
        )
     }
