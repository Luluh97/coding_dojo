import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _http: HttpClient) { 

  }

getTasks(){
  return this._http.get('/tasks')
  }

  postToServer(num){
    // use the .post() method of HttpClient
    // num must be an object
    // provide the url of your post route - make sure this is set up in your server!copy
    return this._http.post('/tasks', num);  
}
}
 
