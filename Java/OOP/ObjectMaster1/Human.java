public class Human{
    Integer strength= 3;
    Integer stealth= 3;
    Integer intelligence= 3; 
    Integer health= 100;

    public void attack(Human hum){
        hum.health -= strength;


    }
}