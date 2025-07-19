import { Component, Input, OnChanges, OnInit, SimpleChanges } from "@angular/core";


@Component({
    selector: 'app-lifecycle',
    template: `<p>Lifecycle works</p>`

})

export class Lifecycle implements OnInit, OnChanges{

    @Input() name : string = '';

    constructor(){
        console.log("Creando el componente");
        
    }

    ngOnInit(): void {
        console.log("Inicializando el componente"); //Primer ciclo -> inicializa el componente
        
    }

    ngOnChanges(changes: SimpleChanges): void { //Realiza acciones cuando los datos de entrada cambian
        console.log("Recibiendo cambios en los parámetros");
    }
}