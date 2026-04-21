import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { RecipeList } from './features/recipes/component/recipe-list/recipe-list';

@Component({
  selector: 'app-root',
  imports: [RecipeList],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('recipe-management');
}
