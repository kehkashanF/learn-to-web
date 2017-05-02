import { Component } from '@angular/core';

@Component({
    selector: 'app-server',
    templateUrl: './server.component.html',
    styles: [`
        .online{
            color: white;
        }
    `]
})
export class ServerComponent{
    serverID: number=1234;
    state ='';

    constructor(){
        this.state = Math.random() > 0.5 ? 'offline' : 'online';
    }
    getServerStatus(){
        return this.state;
    }

    changeColor(){
        return this.state === 'online'? 'green' : 'red';
    }
}