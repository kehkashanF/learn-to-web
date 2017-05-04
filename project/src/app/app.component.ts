import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  nowShowingHeader: string = 'recipe';

  showThis(feature: string){
    this.nowShowingHeader=feature;
  }
}
