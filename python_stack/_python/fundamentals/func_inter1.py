import random
def randInteger(min=0, max=100):
    if(min < max and max > 0):
        num = random.random() * (max-min) + min
        return round(num)

#print("should print a random integer between 0 to 100",randInteger()) 		  
#print("should print a random integer between 0 to 50",randInteger(max=50)) 	    
#print("should print a random integer between 50 to 100",randInteger(min=50)) 	    
print("should print a random integer between 50 and 500",randInteger(min=50, max=500))    