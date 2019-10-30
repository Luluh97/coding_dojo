public class Gorilla extends Mammal{

    public void throwSomething(){
        System.out.println("Throwing");
        energyLevel =- 5;
    }

    public void eatBananas(){
        System.out.println("Eating Banana");
        energyLevel =+ 10;
    }

    public void climb(){
        System.out.println("Climbing");
        energyLevel =- 10;
    }
}