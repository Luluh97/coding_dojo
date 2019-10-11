
class Card {
    constructor(suit, values,numericalVal) {
        this.suit = suit;
        this.values = values;
        this.numericalVal = numericalVal;
    }
    cardInfo (){
      console.log("suit:"+ this.suit + ", values: "+ this.values+" numericalVal: " + this.numericalVal);
    }
}



class Deck {


    constructor() {
        this.cards = [];
        this.suit = ["Hearts", "Clubs","Diamonds", "Spades"];
        this.values = ["Ace","two","three","four","five","six","seven","eight","nine","ten","jocker","queen","king"];
        this.numericalVal=[1,2,3,4,5,6,7,8,9,10,11,12,13];
    }
    // simple function in the child class
    fillCardsArr() {
        var currentSuit
        for(var i=0;i< this.suit.length;i++){
            currentSuit = this.suit[i];
            for(var j=0;j<this.values.length;j++){
            this.cards.push(new Card(currentSuit,this.values[j],this.numericalVal[j]))
            }
        
        }
    }

    shuffle(){

  var m = this.cards.length;
  var i,t;
  while (m) {

    // Pick a remaining element…
    i = Math.floor(Math.random() * m--);

    // And swap it with the current element.
    t = this.cards[m];
    this.cards[m] = this.cards[i];
    this.cards[i] = t;
  }



    }

    reset(){
        this.cards = [];
       return this.fillCardsArr();
    }

    deal(){
        return this.cards.pop()    //splice(1,1); //pop
    }

}


class Player {
    constructor(name,deckObj) {
        this.name = name;
        this.hand = [];
        this.tempD = deckObj;
    }

    fillHand(){
      
        for(var i=0; i<7;i++) // suppose user should take 7 cards
        {
         this.hand.push(this.tempD.deal());

        }
    }

    takeCard (){
     return this.hand.push(this.tempD.deal());
    }

    discardCard (){
         this.hand.pop();
       }
}



var testDeck = new Deck();

    testDeck.fillCardsArr();
    testDeck.shuffle();
   

   var myPlayer = new Player("Dalal",testDeck);
   myPlayer.fillHand()
   myPlayer.takeCard()
   myPlayer.discardCard()

   for(var d=0; d< myPlayer.hand.length;d++){
    console.log(myPlayer.hand[d]);
   }




