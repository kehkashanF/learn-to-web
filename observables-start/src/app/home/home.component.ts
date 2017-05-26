import { Params } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { Observer } from 'rxjs/Observer';
import { Subscription } from 'rxjs/Subscription';
import 'rxjs/Rx';
import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, OnDestroy {
  numObsSubs: Subscription;
  custObsSubs: Subscription;
  constructor() { }

  ngOnInit() {
     const myNumbers = Observable.interval(1000);
    this.numObsSubs = myNumbers.subscribe({
       (number : number) => {
         console.log(number);
      }
     });

    const myObservable = Observable.create((observer: Observer<string>) => {
        setTimeout(() => {observer.next("first package");} ,2000);
        setTimeout(() => {observer.next("second package");} ,4000);
        setTimeout(() => {observer.error("error package");} ,6000);
        setTimeout(() => {observer.complete();} ,7000);
      }
    );

    this.custObsSubs = myObservable.subscribe(
      (data: string) => {console.log(data);},
      (error: string) => {console.log(error);},
      () => {console.log('Complete!');}
    );
  }

  ngOnDestroy(){
    this.numObsSubs.unsubscribe();
    this.custObsSubs.unsubscribe();
  }

}
