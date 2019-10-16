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
  rate: any;
  cake: any;
  newCake: any;
  newRate: any;
  green =  false;
  id = ""
  selected_cake : any;
  selected_rate: any;
  a: any;
  b: any;
  c: any;
  d: any;

  constructor(private _httpService: HttpService){}
  
  ngOnInit(){
    let observable = this._httpService.getCakes()
    observable.subscribe(data => {
      this.recievec = data
      console.log('recieved cake id',this.recievec)
    })
    this.newRate = { stars: "", comment: "" }
    this.newCake = { title: "", description: "" }
  }


onSubmit(){
  
  let observable = this._httpService.addCake(this.newCake)
    observable.subscribe(data => {
      this.cake = data
    })
  console.log(this.newCake._id)
  this.newCake = { name: "", img: "" }
  this.newRate = { stars: "", comment: "" }
  

}

onClick(id){
  this.id=id;
  console.log(this.id)
  console.log(this.newRate._id)
  let observable = this._httpService.addRate(this.id, this.newRate)
    observable.subscribe(data => {
      this.cake = data
    })
  
  this.newRate = { stars: "", comment: "" }

}
getRate(id, idx){
  this.id=id;
  
  let observable = this._httpService.getRate(this.id)
  observable.subscribe(data => {
    this.rate = data
    console.log('recieved rate',this.rate)
    this.cakeToShow(idx)
    this.green = true;
 
  })
  
}

cakeToShow(idx){
  this.selected_cake = this.recievec[idx];
  this.a = this.selected_cake.name
  this.b = this.selected_cake.img
  }
}