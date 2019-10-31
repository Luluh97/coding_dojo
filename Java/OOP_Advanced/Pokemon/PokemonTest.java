public class PokemonTest{
    public static void main(String[] args) {

        Pokemon pok1 = new Pokemon("Pokemon1", 100, "Dinasour");
        Pokemon pok2 = new Pokemon("Pokemon2", 200, "Dinasour");
        pok1.attackPokemon(pok2);

        Pokedex b  = new Pokedex();
        b.listPokemons();

     
    }
}