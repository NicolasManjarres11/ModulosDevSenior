import { Component, computed, effect, signal } from "@angular/core";

@Component({

    selector: 'app-signal-sample',
    imports: [],

    //InLine Template

    template: ` 
        <h1>Signal Counter</h1>

        <p>Counter : {{count()}}</p>

        <button (click)="incrementar()">Incrementar</button>

        <p>{{message()}}</p>

    `                                           
    

})

export class SignalSample{

    protected count = signal<number>(0);
    protected message = computed(() =>`Has dado ${this.count()} click sobre el botón`);

    constructor(){
        effect(() => {

            console.log("El contador es", this.count());
            

            console.log("Hola Mundo", this.message());
            
        }

        )
    }


    incrementar(){
        this.count.update(value => value + 1);
        
    }

}