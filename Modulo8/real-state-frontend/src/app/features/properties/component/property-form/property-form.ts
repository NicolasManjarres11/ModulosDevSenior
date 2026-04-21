import { Component, effect, input, signal } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Property } from '../../model/property.model';
import { PropertyService } from '../../service/propertyService';

@Component({
  selector: 'app-property-form',
/*   standalone: true, */
  imports: [ReactiveFormsModule, FormsModule],
  templateUrl: './property-form.html',
  styleUrl: './property-form.css'
})
export class PropertyForm {

  propertyId = input<string | undefined>();
  error = signal<string | undefined>(undefined);
  loading = signal<boolean>(true);
  isEditMode = signal<boolean>(false);

  propertyForm = new FormGroup({
    id: new FormControl<number | null>(null),
    address: new FormControl<String>('', Validators.required),
    city: new FormControl<string>('', Validators.required),
    price: new FormControl<number| null>(null, [Validators.required, Validators.min(1000)]),
    bedrooms: new FormControl<number | null>(null, [Validators.required, Validators.min(0),Validators.max(10)]),
    bathrooms: new FormControl<number | null>(null, [Validators.required, Validators.min(0),Validators.max(5)]),
    imageUrl: new FormControl<string>('', [Validators.required, Validators.pattern(/^(http|https):\/\/[^ "]+$/)]),
    description: new FormControl<string>('', [Validators.required, Validators.minLength(20)])
  });

  constructor(private router: Router, private service : PropertyService){

    effect(() => {

      if(this.propertyId()){

        this.loading.set(true)
        this.isEditMode.set(true)
        this.error.set(undefined)
  
        const id = parseInt(this.propertyId() ?? "0")

        this.service.getProperty(id).subscribe({
          next: (data) => {
            this.propertyForm.patchValue(data)
            this.loading.set(false);
          },
          error: (error) => {
            this.error.set(error.error.message);
            this.loading.set(false);
          }
        })


      } else{
        this.isEditMode.set(false);
        this.loading.set(false);
      }


    })
}

  

  goBack(){

    if(this.isEditMode()){
      this.router.navigate(['properties', this.propertyId()])
    } else{
      this.router.navigateByUrl("/properties")
    }


  }

  onSave(){
    //Verificar que los campos obligatorios estén llenos
    //Crear un objeto con los datos suministrados
    //Enviar a guardar al servicio de propiedades

    if(this.propertyForm.invalid){
      console.warn("Formulario inválido. No se puede enviar.")
      return;
    }

    const newProperty: Property = this.propertyForm.value as Property
    this.service.addNewProperty(newProperty).subscribe({
      next: (data) => {
        alert("Propiedad agregada correctamente")
        this.goBack();
      },
      error: (error) => {
        this.error.set(error.message || 'Error al guardar la propiedad');
      }
    });
    this.goBack();

    };

    onUpdate(){
      const id= parseInt(this.propertyId()!)
      const property : Property = this.propertyForm.value as Property
      this.service.updateProperty(id, property).subscribe({
        next: (data) => {
          alert('Propiedad actualizada')
          this.goBack();
        },
        error: (error) => {
          this.error.set(error.message || 'Error al actualizar la propiedad');
        }
      });
    }






  }


