import { Component, input, output, signal } from '@angular/core';
import { Recipe } from '../../model/recipes';

@Component({
  selector: 'app-recipe-detail',
  imports: [],
  templateUrl: './recipe-detail.html',
  styleUrl: './recipe-detail.css',
})
export class RecipeDetail {

  readonly recipe = input.required<Recipe>();
  readonly back = output<void>();

  onBack(){
    this.back.emit()
  }

}
