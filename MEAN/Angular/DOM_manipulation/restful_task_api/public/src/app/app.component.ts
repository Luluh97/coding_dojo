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
  tasks = []
  
  constructor(private _httpService: HttpService){}
  

  ngOnInit(){
    let observable = this._httpService.getTasks()
    observable.subscribe(data => {
      this.recievec = data
      this.tasks = data['tasks']
    })
  }
  onButtonClickParamcopy(num: Number): void { 
    console.log(`Click event is working with num param: ${num}`);
}

onButtonClickParam(num: Number): void { 
  console.log(`Click event is working with num param: ${num}`);
  // call the service's method to post the data, but make sure the data is bundled up in an object!
  let observable = this._httpService.postToServer({data: num});
  observable.subscribe(data => console.log("Got our data!", data));
}
}
