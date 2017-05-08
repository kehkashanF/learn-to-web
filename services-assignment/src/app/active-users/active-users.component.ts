import { CounterService } from './../counter.service';
import { UsersService } from './../users.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-active-users',
  templateUrl: './active-users.component.html',
  styleUrls: ['./active-users.component.css'],
  providers: [CounterService]
})
export class ActiveUsersComponent implements OnInit {
  users: string[];
  
  constructor(private usersService : UsersService, private counterS : CounterService){}

  ngOnInit(){
      this.users = this.usersService.activeUsers;
  }

  onSetToInactive(id: number) {
    this.usersService.onSetInactive(id);
    console.log("Active to Inactive: "+ this.counterS.counter++);
  }
}
