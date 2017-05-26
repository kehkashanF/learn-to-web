import { Component, ElementRef, ViewChild } from '@angular/core';
import { NgForm} from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @ViewChild('f') signForm: NgForm;
  defaultQuestion = 'pet';
  answer = '';
  suggestUserName() {
    const suggestedName = 'Superuser';
  }

  // onSubmit(formEl: NgForm){
  //   console.log(formEl);
  // }

  onSubmit(){
    console.log(this.signForm);
  }
}
