import { ShoppingListService } from './../shopping-list/shopping-list.service';
import { Ingredient } from './../shared/ingredient.model';
import { Recipe } from './recipe.model';
import { Injectable, EventEmitter, OnInit } from '@angular/core';

@Injectable()
export class RecipesService implements OnInit{
 
  recipeSelected = new EventEmitter<Recipe>();

  private recipes: Recipe[] = [
    new Recipe('Buldak', 
        'Buldak is a Korean dish made from heavily spiced chicken', 
        'https://upload.wikimedia.org/wikipedia/commons/f/fb/Korean_barbeque-Buldak-01.jpg',
        [
          new Ingredient('Chicken', 1),
          new Ingredient('Hot Pepper Flakes', 3),
          new Ingredient('Soy Sauce', 1),
          new Ingredient('Green Onion', 2),
          new Ingredient('Ginger garlic Paste', 1),
          new Ingredient('Mozzarella Cheese', 1),
          new Ingredient('Rice Syrup', 2),
          new Ingredient('Oil', 1),
          new Ingredient('Black Pepper', 3)
        ]),
    
    new Recipe('Coq au vin', 
        'Coq au vin is a French dish of chicken braised with wine, lardons, mushrooms, and optionally garlic.', 
        'https://i.ytimg.com/vi/HrtpoyY_rak/maxresdefault.jpg',
        [
          new Ingredient('Chicken Thighs and Legs', 3),
          new Ingredient('Garlic Cloves', 6),
          new Ingredient('Pearl Onions', 20),
          new Ingredient('Green Onion', 2),
          new Ingredient('Chicken Stock Cubes', 2),
          new Ingredient('Thyme', 1),
          new Ingredient('Parsley', 2),
          new Ingredient('Bay Leaves', 1),
          new Ingredient('Mushrooms', 30),
          new Ingredient('Butter', 1)
        ]),
    
    new Recipe('Chicken satay', 
        'Chicken satay in the Netherlands with peanut sauce, French fries, prawn crackers, and mayonnaise', 
        'http://www.thelondoner.me/wp-content/uploads/2015/05/Easy-Chicken-Satay-Recipe-11.jpg',
        [
          new Ingredient('Chicken Cubes', 30),
          new Ingredient('Peanut Butter', 1),
          new Ingredient('Soy Sauce', 1),
          new Ingredient('Prawn Crackers', 20),
          new Ingredient('Chicken Stock Cubes', 2),
          new Ingredient('Brown Sugar', 1),
          new Ingredient('Lemon/Limes', 2),
          new Ingredient('Mayonnaise', 1),
          new Ingredient('Butter', 1)
        ]),
    new Recipe('Andong jjimdak', 
      'Andong jjimdak is a variety of jjim (a Korean steamed or boiled dish) made with chicken and various vegetables marinated in a ganjang based sauce.', 
      'http://tong.visitkorea.or.kr/cms/resource/77/553277_image2_1.jpg',
      [
          new Ingredient('Chicken Thighs and Legs', 3),
          new Ingredient('Garlic Cloves', 6),
          new Ingredient('Pearl Onions', 20),
          new Ingredient('Green Onion', 2),
          new Ingredient('Chicken Stock Cubes', 2),
          new Ingredient('Thyme', 1),
          new Ingredient('Parsley', 2),
          new Ingredient('Bay Leaves', 1),
          new Ingredient('Mushrooms', 30)
        ])
  ];
  constructor(private sLService: ShoppingListService) { }

   ngOnInit() {
    
  }

  getRecipes(){
    return this.recipes.slice();
  }

  addIngredientsToShoppingList(ingredients: Ingredient[]){
    this.sLService.addIngredients(ingredients);

  }

}
