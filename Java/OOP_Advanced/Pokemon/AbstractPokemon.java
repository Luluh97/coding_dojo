

    public abstract class AbstractPokemon implements PokemonInterface {
        public Pokemon createPokemon(String name, Integer health, String type){
            return new Pokemon(name1, health1, type1);
        }
    
        public String pokemonInfo(Pokemon pokemon){
            
            return "Name: "+pokemon.getName() + ", Type: "+pokemon.getType()+", Health: "+pokemon.getHealth();
        } 
        
        public  void listPokemons();
    
    }




