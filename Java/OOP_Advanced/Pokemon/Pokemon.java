public class Pokemon {

    String name;
    Integer health;
    String type;
    public static String names = "";
    public static int count = 0;

    public Pokemon(String name1, Integer health1, String type1){
        count++;
        names += " "+name;
        setName(name1);
        setHealth(health1);
        setType(type1);
    }

    public void attackPokemon(Pokemon pokemon){
        pokemon.health -= 10;
        System.out.println(pokemon.health);
    }

    public void setName( String name2){
        this.name = name2;
    }

    public String getName(){
        return name;
    }


    public static String getNames(){
        return names;
    }

    public void setType( String type2){
        this.name = type2;
    }

    public String getType(){
        return type;
    }
    public void setHealth(int health){
        this.health = health;
    }

    public int getHealth(){
        return health;
    }
}