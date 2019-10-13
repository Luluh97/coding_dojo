import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _http: HttpClient) { 
    this.getTasks();
    this.getTasksById();


  }
  getTasks(){
    let tempObservable = this._http.get('/tasks');
    tempObservable.subscribe(data => console.log("Got our tasks!", data));
 }
 getTasksById(){
  let tempObservable = this._http.get('/tasks/:id');
  tempObservable.subscribe(data => console.log("Got our task by ID!", data));
}
}
