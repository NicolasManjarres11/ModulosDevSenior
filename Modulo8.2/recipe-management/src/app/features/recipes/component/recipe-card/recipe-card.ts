import { Component, input, output } from '@angular/core';
import { Recipe } from '../../model/recipes';

@Component({
  selector: 'app-recipe-card',
  imports: [],
  templateUrl: './recipe-card.html',
  styleUrl: './recipe-card.css',
})
export class RecipeCard {
  readonly recipe = input.required<Recipe>();
  readonly show = output<number>();

  onShowRecipe(): void {
    this.show.emit(this.recipe().id);
  }



}
