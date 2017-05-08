import { CounterService } from './../counter.service';
import { UsersService } from './../users.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-inactive-users',
  templateUrl: './inactive-users.component.html',
  styleUrls: ['./inactive-users.component.css'],
  providers: [CounterService]
})
export class InactiveUsersComponent implements OnInit {
  users: string[];
  
  constructor(private usersService : UsersService, private counterS: CounterService){}

  ngOnInit(){
      this.users = this.usersService.inactiveUsers;
  }

  onSetToActive(id: number) {
    this.usersService.onSetActive(id);
    console.log("Inative to Active: "+ this.counterS.counter++);
  }
}
