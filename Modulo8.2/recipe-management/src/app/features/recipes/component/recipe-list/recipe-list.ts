import { Component, computed, OnInit, signal } from '@angular/core';
import { Recipe } from '../../model/recipes';
import { RecipeCard } from '../recipe-card/recipe-card';
import { RecipeDetail } from '../recipe-detail/recipe-detail';

@Component({
  selector: 'app-recipe-list',
  imports: [RecipeCard, RecipeDetail],
  templateUrl: './recipe-list.html',
  styleUrl: './recipe-list.css',
})
export class RecipeList implements OnInit{

  protected readonly recipes = signal<Recipe[]>([]);
  private selectedId = signal<number>(0);
  protected readonly showList = computed(() => this.selectedId() === 0);
  protected readonly recipeSelected = computed(() => this.recipes()
  .filter(r => r.id === this.selectedId())[0]);

  ngOnInit(): void {
      
    this.recipes.set([
      {
        id: 1,
        title: "Pasta Carbonara",
        description: "Clásica pasta italiana con huevo y tocineta",
        ingredients: [
          {
            name: 'Pasta',
            quantity: 1,
            units: "libra",
          },
          {
            name: 'Tomate',
            quantity: 3,
            units: "Kilo",
          }
        ],
        instructions: [
          "La salsa carbonara tradicional es facile, ma non troppo, que traducido quiere decir algo como que es fácil de preparar, pero no tanto como parece, ya que aunque los pasos son sencillos, hay que ejecutarlos con precisión para conseguir el resultado deseado. Al empezar, ponemos agua abundante con sal en una olla grande, cortamos la panceta en tiras y la ponemos a dorar en una sartén. Reservamos la panceta cuando esté dorada.",
          "Por otro lado, en un bol batimos las yemas de los dos huevos e incorporamos el queso rallado junto con una pizca de sal y pimienta. Hay quien usa también las claras de los huevos (o solo la mitad de las claras), pero a mi me gusta solo con las yemas, reservando las claras para hacer con ellas otro día un postre o una tortilla.",
          "Cuando el agua hierva, añadimos la pasta, cocemos durante el tiempo que indique el envase para que quede al dente y la escurrimos. Sin dejar que se enfríe la pasta la volvemos a poner en la cazuela y la mezclamos con el huevo batido y el queso."
        ],
        imageUrl: "https://www.cookingclassy.com/wp-content/uploads/2020/10/spaghetti-carbonara-01.jpg"
      },
      {
        id: 2,
        title: "Pasta bolognesa",
        description: "Clásica pasta con salsa d3e tomáte y albondigas",
        ingredients: [
          {
            name: 'Parta',
            quantity: 1,
            units: "libra",
          },
          {
            name: "Llema de huevo",
            quantity: 3,
            units: "Unidades"
          },
                    {
            name: "Carne molida",
            quantity: 1,
            units: "kilo"
          }
        ],
        imageUrl: "https://www.laespanolaaceites.com/wp-content/uploads/2019/05/espaguetis-a-la-bolonesa.jpg"
      },
    ])
  }

  onShowRecipe(id: number){
    alert("Evento recibido de: "+ id);
    this.selectedId.set(id);
  }

  backToList(){
    this.selectedId.set(0);
  }

}
