class Bike{
    price : number
    max_speed : number
    miles : number

    constructor(price: number, max_speed : number){
        this.price = price;
        this.max_speed = max_speed;
        this.miles = 0
    }

    displayInfo = () => {
        return console.log('the bikes price is '+this.price+'$, maximum speed is '+this.max_speed+', and the total miles are '+this.miles)
    }

    ride = () => {
        this.miles = this.miles + 10
        console.log("Riding")
        return this
    }

    reverse = () => {
        this.miles = this.miles - 50
        console.log("Reversing")
        return this
    }
}

let rider1 = new Bike(1000,80)
rider1.ride().ride().ride().reverse().displayInfo()

// let rider2 = new Bike(2000,160)
// rider2.ride().ride().reverse().reverse().displayInfo()

// let rider3 = new Bike(3000, 240)
// rider3.reverse().reverse().reverse().displayInfo()
