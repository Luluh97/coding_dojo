public class Pokedex extends AbstractPokemon {
    String myPokemons = Pokemon.getNames();
    public void listPokemons() {
        System.out.println(myPokemons);
    }
}
