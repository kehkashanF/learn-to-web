import { Directive, HostListener, HostBinding } from '@angular/core';

@Directive({
  selector: '[appDropdown]'
})
export class DropdownDirective {
  @HostBinding('class.open') isOpen = false;

   @HostListener('mouseenter') toggleOpen(){
      this.isOpen=true;
  }

   @HostListener('click') toggleOpenClick(){
      this.isOpen=!this.isOpen;
  }

   @HostListener('mouseleave') toggleClose(){
      this.isOpen=false;
  }
  constructor() { }

}
