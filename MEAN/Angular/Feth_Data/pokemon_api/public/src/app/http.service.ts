import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _http: HttpClient) {
    this.getPokemon();
    this.PokemonInfo();
    this.chlorophyll();
    this.overgrow();
}
getPokemon(){
    let bulbasaur = this._http.get("https://pokeapi.co/api/v2/pokemon/1/");
    bulbasaur.subscribe((data:any) => {
      console.log('Got our Pokemon',data)
    })
  }

PokemonInfo(){
    let bulbasaur = this._http.get("https://pokeapi.co/api/v2/pokemon/1/");
    bulbasaur.subscribe((data:any) => {
      console.log(`${data.name}'s abilities are ${data.abilities[0].ability.name} and ${data.abilities[1].ability.name}.`);
    })
  }

chlorophyll(){
    let bulbasaur = this._http.get("https://pokeapi.co/api/v2/ability/34/");
    bulbasaur.subscribe((data:any) => {
      console.log(`${data.pokemon.length }'s Pokemon have the chlorophyll ability.`);
    })
  }

overgrow(){
    let bulbasaur = this._http.get("https://pokeapi.co/api/v2/ability/65/");
    bulbasaur.subscribe((data:any) => {
      console.log(`${data.pokemon.length }'s Pokemon have the overgrow ability.`);
    })
  }

}


