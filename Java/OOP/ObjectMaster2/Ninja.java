public class Ninja extends Human{
    Integer stealth = 10;

    public void steal(human hum){
        hum.health -= stealth;
        health += stealth;
    }

    public void runAway(){
        health -= 10;
    }
}