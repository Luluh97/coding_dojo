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



class User:

    def __init__(self, username, email):
        self.name = username
        self.email = email
        self.account = BankAccount(int_rate="2%", balance=0)
        self.transfer_amount = 0
        
    
    def make_deposit(self, amount):
        self.account.balance += amount
        return self
    
    def make_withdrawl(self, amount):
        self.account.balance -= amount
        return self

    def display_user_balance(self):
        print("Your balance is",self.account.balance)
        return self
    
    # def transfer_money(self, name, amount):
    #     self.balance -= amount
    #     name.balance += amount
    #     print("after transfer ",self.balance)
    #     print("after recieving", name.balance)
    #     return self

        

luluh = User("Luluh","luluh@site.com")
guido = User("Guido","guido@site.com")
monty = User("Monty","monty@site.com")



luluh.make_deposit(100).make_deposit(200).make_deposit(300).make_withdrawl(100).display_user_balance();

guido.make_deposit(100).make_deposit(200).make_withdrawl(50).make_withdrawl(50).display_user_balance();

monty.make_deposit(2000).make_withdrawl(500).make_withdrawl(500).make_withdrawl(500).display_user_balance();



