import { Component, OnInit,  } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
parameter;
  constructor(private _route: ActivatedRoute){}
  ngOnInit(){
      this._route.params.subscribe(params => {
        console.log(`The parent params: ${params}`)
        this.parameter =  params['id'];
        console.log('param', this.parameter)
      })
  }

}

