public class Bat extends Mammal{
    
    public void fly(){
        System.out.println("Flying");
        energyLevel =- 50;
    }

    public void eatHumans(){
        System.out.println("Killing");
        energyLevel =+ 25;

    }

    public void attackTown(){
        System.out.println("On fire");
        energyLevel =- 100;

    }


}