
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _http: HttpClient) { 

  }

getCakes(){
  return this._http.get('/cakes')
  }

addCake(newcake){
  return this._http.post('/cakes', newcake)
}

addRate(id, newrate){
  return this._http.post('/rates/'+id, newrate)
}

getRate(id){
  return this._http.get('/cakes/'+id);
}

}
 
