import { Component, OnInit } from '@angular/core';
import { Recipe } from '../recipe.model';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {

  recipes: Recipe[] = [
    new Recipe('Buldak', 'Buldak is a Korean dish made from heavily spiced chicken', 'https://upload.wikimedia.org/wikipedia/commons/f/fb/Korean_barbeque-Buldak-01.jpg'),
    new Recipe('Coq au vin', 'Coq au vin is a French dish of chicken braised with wine, lardons, mushrooms, and optionally garlic.', 'https://i.ytimg.com/vi/HrtpoyY_rak/maxresdefault.jpg'),
    new Recipe('Chicken satay', 'Chicken satay in the Netherlands with peanut sauce, French fries, prawn crackers, and mayonnaise served in Amsterdam', 'http://www.thelondoner.me/wp-content/uploads/2015/05/Easy-Chicken-Satay-Recipe-11.jpg'),
    new Recipe('Andong jjimdak', 'Andong jjimdak is a variety of jjim (a Korean steamed or boiled dish) made with chicken and various vegetables marinated in a ganjang based sauce.', 'http://tong.visitkorea.or.kr/cms/resource/77/553277_image2_1.jpg')
  ];

  constructor() { }

  ngOnInit() {
  }

}
