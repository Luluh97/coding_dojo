1. 
var myString: string;
myString = "Bee stinger";
myString = 9;

// Why is there a problem with this? What can I do to fix this?
//myString is of type string so it can't be assigned a number value
// To fix it assign it to another variable of type number
var myString: string;
myString = "Bee stinger";
var myNum: Number;
myNum = 9;


2.
function sayHello(name: string){
   return `Hello, ${name}!`;
}
// This is working great:
console.log(sayHello("Kermit"));
// Why isn't this working? I want it to return "Hello, 9!"
console.log(sayHello(9));

//functin only accepts string parameter, hence, pass the 9 as string 
console.log(sayHello('9'));



3.

function fullName(firstName: string, lastName: string, middleName: string){
   let fullName = `${firstName} ${middleName} ${lastName}`;
   return fullName;
}
// This works:
console.log(fullName("Mary", "Moore", "Tyler"));
// What do I do if someone doesn't have a middle name?
console.log(fullName("Jimbo", '', "Jones"));

//Pass an empty string or add an interface


4.

interface Student {
   firstName: string;
   lastName: string;
   belts: number;
}
function graduate(ninja: Student){
   return `Congratulations, ${ninja.firstName} ${ninja.lastName}, you earned ${ninja.belts} belts!`;
}
const christine = {
   firstName: "Christine",
   lastName: "Yang",
   belts: 2
}
const jay = {
   firstName: "Jay",
   lastName: "Patel",
   belts: 4
}
// This seems to work fine:
console.log(graduate(christine));
// This one has problems:
console.log(graduate(jay));

//spelling mistake in jay object it's belts not belt


5.

class Ninja {
   fullName: string;
   constructor(
      public firstName: string,
      public lastName: string){
         this.fullName = `${firstName} ${lastName}`;
      }
   debug(){
      console.log("Console.log() is my friend.")
   }
}
// This is not making an instance of Ninja, for some reason:
const shane = new Ninja('Luluh','Adel');
// Since I'm having trouble making an instance of Ninja, I decided to do this:
// const turing = {
//    fullName: "Alan Turing",
//    firstName: "Alan",
//    lastName: "Turing"
// }
// Now I'll make a study function, which is a lot like our graduate function from above:
function study(programmer: Ninja){
   return `Ready to whiteboard an algorithm, ${programmer.fullName}?`
}
// Now this has problems:
console.log(study(shane));


6.

function increment (x: number)  {
     x + 1
}
// This works great:
console.log(increment(3));
function square (x: number)  {
     x * x
}
console.log(square(4));

function multiply (x: number,y: number)  {
     x * y
}


function math(x: number, y: number) { 
    let sum = x + y;
    let product = x * y;
    let difference = Math.abs(x - y);
    return [sum, product, difference];
}
   
   
  
7.

class Elephant {
   constructor(public age: number){}
   birthday = () => {
      this.age++;
   }
}
const babar = new Elephant(8);
setTimeout(babar.birthday, 1000)
setTimeout(function(){
   console.log(`Babar's age is ${babar.age}.`)
   }, 2000)

