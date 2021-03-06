import { Subject } from 'rxjs/Subject';
import { Ingredient } from './../shared/ingredient.model';
import { Injectable, EventEmitter } from '@angular/core';

@Injectable()
export class ShoppingListService {

  ingredientsChaanges = new Subject<Ingredient[]>();

  private ingredients: Ingredient[] = [
    new Ingredient('Chicken', 1),
    new Ingredient('Tomatoes', 10),
    new Ingredient('Onion', 5)
  ];
  
  constructor() { }

  getIngredients(){
    return this.ingredients.slice();
  }

  addIngredient(ingredient: Ingredient){
    this.ingredients.push(ingredient);
    this.ingredientsChaanges.next(this.ingredients.slice());
  }

  addIngredients(ingredients: Ingredient[]){
    this.ingredients.push(...ingredients);
    this.ingredientsChaanges.next(this.ingredients.slice());
  }

}
