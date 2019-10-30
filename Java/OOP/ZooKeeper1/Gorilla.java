public class Gorilla extends Mammal{

    public int throwSomething(){
        System.out.println("Throwing");
        energyLevel = energyLevel - 5;
        return energyLevel;
    }

    public int eatBananas(){
        System.out.println("Eating Banana");
        energyLevel = energyLevel + 10;
        return energyLevel;
    }

    public int climb(){
        System.out.println("Climbing");
        energyLevel = energyLevel - 10;
        return energyLevel;
    }
}