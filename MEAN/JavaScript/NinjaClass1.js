function Ninja(name) {

    this.name = name;
    this.health = 100;
     this.speed = 3;
    this.strenght = 3; 
    this.sayName = function(){
        console.log("My ninja name is " + this.name + "!");
    }
    this.showStats = function(){
        console.log("Name: "+ this.name + ", Health: "+this.health+", Speed: :"+this.speed+", Strength: "+this.strenght);
    }
    this.drinkShake = function(){
       this.health += 10
       
    }
  
}
var ninja1 = new Ninja("Hyabusa");
ninja1.sayName();
ninja1.drinkShake()
ninja1.showStats();
