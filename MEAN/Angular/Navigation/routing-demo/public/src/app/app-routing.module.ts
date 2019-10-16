import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SeatleComponent } from './seatle/seatle.component';
import { DcComponent } from './dc/dc.component';
import { SanjoseComponent } from './sanjose/sanjose.component';
import { DallasComponent } from './dallas/dallas.component';
import { ChicagoComponent } from './chicago/chicago.component';
import { BurbankComponent } from './burbank/burbank.component';

const routes: Routes = [
  {path: 'seatle', component: SeatleComponent},
  {path: 'dc', component: DcComponent},
  {path: 'sanjose', component: SanjoseComponent},
  {path: 'dallas', component: DallasComponent},
  {path: 'chicago', component: ChicagoComponent},
  {path: 'burbank', component: BurbankComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [SeatleComponent, DcComponent, SanjoseComponent, DallasComponent, ChicagoComponent, BurbankComponent]