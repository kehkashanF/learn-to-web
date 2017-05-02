import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  display=false;
  clicks=[];

  logClicks(){
    this.display=!this.display;
    this.clicks.push(new Date());
  }

}
