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
  newTask: any;
  updateTask: any;
  green =  false;
  id = ""
  constructor(private _httpService: HttpService){}
  

  ngOnInit(){
    this.newTask = { title: "", description: "" }
    this.updateTask = { title: "", description: "" }
      this.GetAll()
  }

GetAll(){
  let observable = this._httpService.getTasks()
  observable.subscribe(data => {
    this.recievec = data
  })
}
onSubmit(){
  
  let observable = this._httpService.addTask(this.newTask)
    observable.subscribe(data => {
      this.task = data
    })
  console.log(this.newTask._id)
  this.newTask = { title: "", description: "" }

}
GetTask(id){
  this.green = true;
  this.id = id;
  this.updateTask = { title: "", description: "" }
  let observable = this._httpService.getTasksById(this.id)
    observable.subscribe(data => {
      this.updateTask = data
      console.log("get",this.updateTask)
    
    })
}

DeleteTask(id){
  this.id = id;
  let observable = this._httpService.deleteTask(this.id)
    observable.subscribe(data => {
    console.log('deleted', data)
    
    })
}

EditTask(){
 
  console.log("edit",this.updateTask)
  let observable = this._httpService.editTask(this.id, this.updateTask)
  observable.subscribe((data:any) => {
    this.updateTask = {title: data.title, description: data.description}
    console.log('after', this.updateTask)
  })
  this.GetAll()
  this.id = "" 
}
}

