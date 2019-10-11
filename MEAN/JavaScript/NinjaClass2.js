function Ninja(name) {

    this.name = name;
    this.health = 100;
    this.speed = 3;
    this.strength = 3; 
    this.sayName = function(){
        console.log("My ninja name is " + this.name + "!");
    }
    this.showStats = function(){
        console.log("Name: "+ this.name + ", Health: "+this.health+", Speed: :"+this.speed+", Strength: "+this.strength);
    }
    this.drinkShake = function(){
       this.health += 10
       
    }
    this.punch = function(punched){
        if(punched instanceof Ninja){
            punched.health-=5
            console.log(punched.name+" was punched by "+this.name+" and lost 5 Health!")

        }
    }
    this.kick = function(kicked){
        if (kicked instanceof Ninja) {
            lost = this.strength * 15;
            kicked.health -= lost;
            console.log(kicked.name + " was kicked by " + this.name + " and lost " + kicked.health + " health!");
        }
    }
  
}

var blueNinja = new Ninja("Goemon");
var redNinja = new Ninja("Bill Gates");
redNinja.punch(blueNinja);
blueNinja.kick(redNinja);
