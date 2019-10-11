class User:

    def __init__(self, username, email):
        self.name = username
        self.email = email
        self.balance = 0
        self.transfer_amount = 0
        
    
    def make_deposit(self, amount):
        self.balance += amount
        return self
    
    def make_withdrawl(self, amount):
        self.balance -= amount
        return self

    def display_user_balance(self):
        print("Your balance is",self.balance)
        return self
    
    def transfer_money(self, name, amount):
        self.balance -= amount
        name.balance += amount
        print("after transfer ",self.balance)
        print("after recieving", name.balance)
        return self

        

luluh = User("Luluh","luluh@site.com")
guido = User("Guido","guido@site.com")
monty = User("Monty","monty@site.com")



luluh.make_deposit(100).make_deposit(200).make_deposit(300).make_withdrawl(100).display_user_balance().transfer_money(monty, 50);

guido.make_deposit(100).make_deposit(200).make_withdrawl(50).make_withdrawl(50).display_user_balance();

monty.make_deposit(2000).make_withdrawl(500).make_withdrawl(500).make_withdrawl(500).display_user_balance();



