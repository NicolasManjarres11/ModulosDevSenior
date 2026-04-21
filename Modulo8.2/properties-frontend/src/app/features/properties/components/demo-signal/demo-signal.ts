import { Component, computed, effect, signal } from "@angular/core";

@Component({
    selector: 'app-demo-signal',
    imports: [],
    templateUrl: './demo-signal.html',
    styleUrl: './demo-signal.css'
})

export class demoSignal{

    protected readonly count = signal(0);

    protected readonly message = computed(() => `Ha cambiado el calor del contador a ${this.count()}`);

    constructor(){
        effect(() => {
            console.log(this.message());
            
        });
    }


    increment(): void {
        this.count.update(current => current + 1);
    }

}