import { Component, OnInit, signal } from "@angular/core";
import { Property } from "../../model/property";
import { PropertyService } from "../../service/property-service";
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from "@angular/forms";
import { Router } from "@angular/router";

@Component({
    selector: 'app-property-form',
    imports: [ReactiveFormsModule],
    templateUrl: './property-form.html',
    styleUrl: './property-form.css',


})

export class PropertyForm implements OnInit{

    protected propertyGroup: FormGroup;




    constructor(
        private propertyServie: PropertyService,
        private router: Router,
        private fb: FormBuilder
    ){

        
/*         this.propertyGroup = new FormGroup({
            address: new FormControl<string>('', Validators.required),
            description: new FormControl<string>('',Validators.required),
            city: new FormControl<string>('',Validators.required),
            price: new FormControl<number>(0,[Validators.required, Validators.min(100)]),
            bedrooms: new FormControl<number>(0,[Validators.required, Validators.min(1)]),
            bathrooms: new FormControl<number>(0,[Validators.required, Validators.min(1), Validators.max(5)]),
            image: new FormControl<string>('', [Validators.required ,Validators.pattern('https?:\/\/.*')])
        }) */

            this.propertyGroup = fb.group({
                address: ['',Validators.required],
                description: ['', Validators.required],
                city:['', Validators.required],
                price:[500, [Validators.required, Validators.min(100)]],
                bedrooms:[0, [Validators.required, Validators.min(1)]],
                bathrooms:[0, [Validators.required, Validators.min(1), Validators.max(5)]],
                image:['', [Validators.required ,Validators.pattern('https?:\/\/.*')]]
            });

    }
    ngOnInit(): void {

    }

    onSave(): void{
        if(this.propertyGroup.valid) {
            const info: Omit<Property, 'id'> = this.propertyGroup.value;
            this.propertyServie.create(info).subscribe({
                next: () => {
                    
                    alert("Se ha creado la propiedad exitosamente");
                    this.router.navigateByUrl("/properties");
                },
                error: () => {
                    alert("Error al crear la propiedad");
                }
            });

        }
    }

}