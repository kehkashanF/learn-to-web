import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  oddNumbers: number[] = [];
  evenNumbers: number[] =[];

  onIntervalFired(countThis: number){
    if(countThis%2===0)
      this.evenNumbers.push(countThis);
    else
        this.oddNumbers.push(countThis);
    }
  }


