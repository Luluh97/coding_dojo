#Basic
for x in range(151):
    print(x)

#Multiple of Five
for x in range(5,1000):
    if x%5 == 0:
        print(x)

#Counting, the Dojo Way
for x in range(1,100):
    if x%5 == 0:
        print("Coding")
    if x%10 == 0:
        print("Coding Dojo")
    else:
        print(x)

#Whoa. That Sucker's Huge
sum = 0
for x in range(0,500000):
    if(x%2 != 0):
        sum+=x

print(sum)

#Countdown by Fours
for x in range(2018,0,-4):
    print(x)

#Flexible Counter
lowNum=2
highNum=9
mult=3
for x in range(lowNum,highNum):
    if(x%mult==0):
        print(x)

