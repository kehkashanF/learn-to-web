import { Component, OnInit } from '@angular/core';
import { Ingredient } from '../shared/ingredient.model';

@Component({
  selector: 'app-shopping-list',
  templateUrl: './shopping-list.component.html',
  styleUrls: ['./shopping-list.component.css']
})
export class ShoppingListComponent implements OnInit {
  ingredients: Ingredient[] = [
    new Ingredient('Chicken', 1),
    new Ingredient('Tomatoes', 10),
    new Ingredient('Onion', 5)
  ];
 
  constructor() { }

  ngOnInit() {
  }

  addIngredient(ingredient: Ingredient){
    this.ingredients.push(ingredient);
  }

}
