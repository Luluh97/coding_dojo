public class Wizard extends Human{
    Integer health = 50;
    Integer intellegence = 8;

    public void heal(Human hum){
        hum.health += intelligence;
    }

    public void fireball(Human hum){
        hum.health -= (intelligence * 3);
    }
}