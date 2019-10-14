import { Component, OnInit } from '@angular/core';
import { HttpService } from './http.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'MEAN';
  recievec: any;
  task: any;
  a: string;
  b: string;
  c: boolean;
  green = false;
  
  constructor(private _httpService: HttpService){}
  

  ngOnInit(){
    
  }
  allTasksClick(): void { 
    let observable = this._httpService.getTasks()
    observable.subscribe(data => {
      this.recievec = data
    })
}

Show(idx){
  this.task = this.recievec[idx];
  this.a = this.task.title
  this.b = this.task.description
  this.c = this.task.completed
  this.green = true;
}


}
