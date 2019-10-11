class BankAccount:

    def __init__(self, int_rate = "0%", balance = 0):
        self.rate = int_rate
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount
        return self
    
    def withdraw (self, amount):
        if amount <= self.balance:
            self.balance -= amount
            return self
        else:
            print("Insufficient funds: Charging a $5 fee")
            self.balance -= 5
    
    def display_account_info(self):
        print("Balance: $", self.balance)
        return self
    


    def yield_interest(self):
        deci_rate = float(self.rate.strip('%'))/100
        if deci_rate > 0:
            self.balance = deci_rate * self.balance
            return self 


    



account1 = BankAccount("2%", 5000)
account1.deposit(1000).deposit(1000).deposit(1000).withdraw(4000).yield_interest().display_account_info()

account2 = BankAccount("2%", 1000)
account2.deposit(100).deposit(100).withdraw(10).withdraw(10).withdraw(10).withdraw(10).yield_interest().display_account_info();