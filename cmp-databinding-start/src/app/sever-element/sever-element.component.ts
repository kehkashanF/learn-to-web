import { Component, 
  OnInit, 
  Input, 
  OnChanges, 
  SimpleChanges,
  DoCheck,
AfterContentInit,
OnDestroy,
ContentChild,
ElementRef } from '@angular/core';

@Component({
  selector: 'app-server-element',
  templateUrl: './sever-element.component.html',
  styleUrls: ['./sever-element.component.css']
})
export class SeverElementComponent implements 
OnInit, 
OnChanges, 
DoCheck, AfterContentInit ,
OnDestroy{
  @Input('srvElement') element: {type: string, name:string, content: string};
  @ContentChild('contentParagraph') contentParagraph: ElementRef;
  
  
  constructor() {
    console.log("Server Contructor");
   }

   ngOnChanges(changes: SimpleChanges){ //only hook that receives argument (changes)
    console.log("Server ngOnChanges");
    console.log("Changes:" +changes);
   }

  ngOnInit() {
    console.log("Server ngOnInit");
  }

  ngDoCheck() {
    console.log("Server ngDoCheck");
  }

ngAfterContentInit(){
  console.log("Server ngAfterContentInit");
}

ngOnDestroy(){
  console.log("Server ngOnDestroy");
}
}
