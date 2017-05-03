import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {

  interval;
  @Output() intervalFired=new EventEmitter<number>();
  thisCount=0;
  constructor() { }

  ngOnInit() {
    
  }

  getStarted(){
      this.interval = setInterval(
          () => {
            this.intervalFired.emit(this.thisCount + 1);
            this.thisCount++;
        }, 1000); 
    }

    nowStop(){
      clearInterval(this.interval);
    }
}
