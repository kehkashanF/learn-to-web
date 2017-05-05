import { Directive, Renderer2, OnInit, ElementRef, HostListener, HostBinding, Input } from '@angular/core';

@Directive({
  selector: '[appBetterHighlight]'
})
export class BetterHighlightDirective implements OnInit {
  @Input() defColor: string = 'pink';
  @Input() hlColor: string = 'navyblue';

   @HostBinding('style.backgroundColor') backgroundColor; 

   constructor(private elRef: ElementRef,private renderer: Renderer2) { }

     ngOnInit(): void {
     //this.renderer.setStyle(this.elRef.nativeElement, 'background-color', 'violet');
     this.backgroundColor=this.defColor;
    }

    @HostListener('mouseenter') mouseover(eventData: Event){
          //  this.renderer.setStyle(this.elRef.nativeElement, 'background-color', 'violet');
          this.backgroundColor=this.hlColor;
    }

    @HostListener('mouseleave') mouseleave(eventData: Event){
          //  this.renderer.setStyle(this.elRef.nativeElement, 'background-color', 'yellow');
      this.backgroundColor = this.defColor;
    }

   
}
