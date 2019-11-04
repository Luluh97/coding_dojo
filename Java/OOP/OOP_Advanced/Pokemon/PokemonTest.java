public class PokemonTest {
    public static void main(String[] args) {

        Pokedex b  = new Pokedex();
        Pokemon pok1 = b.createPokemon("Pokemon1", 100, "Dinasour");
        Pokemon pok2 = b.createPokemon("Pokemon2", 200, "Dinasour");
        pok1.attackPokemon(pok2);
        System.out.println(b.pokemonInfo(pok1));
        System.out.println(b.pokemonInfo(pok2));
        b.listPokemons();
    }
}