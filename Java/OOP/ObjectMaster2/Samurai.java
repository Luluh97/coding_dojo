public class Samurai extends Human{
    Integer health = 200;
    Integer counter = 0;

    public Samurai(){
        counter ++;
    }
    public void deathBlow(Human hum){

        hum.health = 0;
        health = health / 2;
    }

   public void meditate(){
    health = health * 2;
    }

    public int howMany(){
        return counter;
    }

}