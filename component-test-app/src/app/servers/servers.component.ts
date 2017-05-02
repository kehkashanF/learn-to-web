import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-servers',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {
  allowNewServer = false;
  serverCreationStatus = 'None created';
  serverName='';
  serverCreated=false;
  servers= ['server1', 'server2'];

  constructor() { 
    setTimeout(() => {
      this.allowNewServer=true;
    },2000);
  }

  ngOnInit() {
  }

  onCreateServer(){
    this.serverCreated=true;
    this.servers.push(this.serverName);
     this.serverCreationStatus = 'Created server with name: '+this.serverName;
  }

  onUpdateServerName(event: Event){
      this.serverName=(<HTMLInputElement>event.target).value;
  }

}
