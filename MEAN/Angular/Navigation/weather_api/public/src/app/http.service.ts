
  import { Injectable } from '@angular/core';
  import { HttpClient } from '@angular/common/http';
  import 'rxjs/add/operator/map';
  
  @Injectable({
    providedIn: 'root'
  })
  export class HttpService {
  
    constructor(private _http: HttpClient) { 
  
    }
  
  
    getWeather(city: string) {
    
      return this._http.get(`http://api.openweathermap.org/data/2.5/weather?q=${city}&APPID=0543b8da9d66ac58e3313ebca27108f8`)
       
  }
}
  
  