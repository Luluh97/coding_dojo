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
  selected_task: any;
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

taskToShow(idx){
  this.selected_task = this.recievec[idx];
  this.a = this.selected_task.title
  this.b = this.selected_task.description
  this.c = this.selected_task.completed
  this.green = true;
}


}
