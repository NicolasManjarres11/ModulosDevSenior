import { Component, effect, input, OnInit, signal } from '@angular/core';
import { Property } from '../../model/property.model';
import { CurrencyPipe } from '@angular/common';
import { PropertyService } from '../../service/propertyService';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-property-detail',
  /* standalone: true, */
  imports: [CurrencyPipe, RouterLink],
  templateUrl: './property-detail.html',
  styleUrl: './property-detail.css'
})
export class PropertyDetail{

  propertyId = input<string | undefined>();
/*   propertyId = signal<string | undefined>(undefined); */
  loading = signal<boolean>(true);
  error = signal<string | undefined>(undefined);
  propertyDetail = signal<Property | undefined>(undefined);

  constructor(
    private propertyService: PropertyService,
    private router: Router
  ){

    effect(() => {

      const id = this.propertyId();

      if(id){
        const idNum = parseInt(id);
        if(!isNaN(idNum)){    //NaN = Not a Number
          //Cargar el detalle de la propiedad

          this.getPropertyDetail(idNum);

        } else{
          this.error.set("ID de la propiedad inválida.");
          this.loading.set(false);
        }
      } else {
        this.error.set("ID de la propiedad no ha sido ingresado.");
        this.loading.set(false);
      }

    });
  }

  //Aqui definimos el metodo que va a tomar la ruta del id y va atomar el parametro que pide, este parametro se coloca en el link de la pagina
/*   ngOnInit(): void {
      const id = this.route.paramMap
        .subscribe(
          (params: ParamMap) => {
            this.propertyId.set(params.get('propertyId') ?? undefined); //Operador ternario
          }
        );
  } */


  private getPropertyDetail(id: number){

    this.propertyDetail.set(undefined);
    this.error.set(undefined);
    this.loading.set(true);

    this.propertyService.getProperty(id).subscribe({
      next: (data) => {
        this.propertyDetail.set(data);
        this.loading.set(false);
      },
      error: (error) => {

        this.error.set(error.error.message);
        this.loading.set(false);
      }
    })

 /*    this.propertyService.getProperty(id)
      .then(p => {
        this.propertyDetail.set(p)
        this.loading.set(false);
      })
      .catch(error => {
        this.error.set(error)
        this.loading.set(false);
      })
 */
  }

  goBack(): void {
    this.router.navigateByUrl("/properties") 
  }

  onDeleteProperty(): void{

    this.error.set(undefined);
    this.loading.set(true);

    
    this.propertyService.deleteProperty(parseInt(this.propertyId()!)).subscribe({
      next: () => {
        alert("Propiedad eliminada correctamente.")
        this.loading.set(false);
        this.goBack();
      },
      error: (error) => {
        console.log("ERROR AL ELIMINAR:", error);
        if (error.error && error.error.message) {
          this.error.set(error.error.message);
        } else if (error.message) {
          this.error.set(error.message);
        } else {
          this.error.set('Error al eliminar la propiedad');
        }
        this.loading.set(false);
      }
    });
  }

}
