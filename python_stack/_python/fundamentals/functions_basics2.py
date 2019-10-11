# #count down
def countDown(num):
    arr = [];
    for x in range(num,0,-1):
        arr.append(x)
    arr.append(0)
    return arr;

b=countDown(5)
print(b)

#print and return 
def print_and_return(list):
    print(list[0])
    return list[1]

b = print_and_return([1,2])
print(b)

#first plus length
def first_plus_length(list):
    return list[0]+len(list)
b= first_plus_length([1,2,3,4,5])
print(b)

#Values Greater than Second

def values_greater_than_second(list):
    arr= []
    count = 0
    for x in range(0, len(list)):
        if list[x]>list[1]:
            arr.append(list[x])
            count += 1
    print(count)
    return (arr)

b= values_greater_than_second([5,2,3,2,1,4])
print(b)

#This Length, That Value
def  length_and_value(size,value):
    arr = []
    for x in range(0,size):
        arr.append(value)
    return arr


b=length_and_value(4,7)
print(b)