#Biggie Size
def biggie_size(li):
    for x in range(0,len(li)):
        if li[x] > 0:
            li[x]="big"
    return li

b=biggie_size([-1, 3, 5, -5]) 
print(b)

#Count Positives
def count_positives(li):
    count = 0
    for x in range(0,len(li)-1):
        count += 1
    li[len(li)-1] = count;
    return li

b= count_positives([-1,1,1,1])
print(b)

#Sum Total
def sum_total(li):
    sum = 0
    for x in range(0,len(li)):
        sum+=li[x]
    return sum
b= sum_total([1,2,3,4])
print(b)

#average
def average(li):
    sum = 0
    for x in range(0,len(li)):
        sum+=li[x]
    return sum/len(li)
b= average([1,2,3,4])
print(b)

#Length
def length(li):
    return len(li)
b=length([37,2,1,-9])
print(b)

#minimum
def minimum(li):
    min = li[0]
    for x in range(0,len(li)):
        if li[x]<min:
            min = li[x]
    return min

b= minimum([37,2,1,-9]);
print(b)

#maximum
def maximum(li):
    max = li[0]
    for x in range(0,len(li)):
        if li[x]>max:
            max = li[x]
    return max

b= maximum([37,2,1,-9]);
print(b)

#ultimate_analysis
def ultimate_analysis(li):
    arr = []
    sum = 0
    max = li[0]
    min = li[0]
    for x in range(0,len(li)):
        sum+=li[x]
    avg  = sum/len(li)
    for x in range(0,len(li)):
        if li[x]>max:
            max = li[x]
    for x in range(0,len(li)):
        if li[x]<min:
            min = li[x]
    arr.append(sum)
    arr.append(avg)
    arr.append(max)
    arr.append(min)
    return arr
b= ultimate_analysis([37,2,1,-9]) 
print (b)


def reverse_list(list):
    length = len(list)
    temp = length

    reversed = [None]*length
    for x in list:
        temp = temp - 1
        reversed[temp] = x
    return reversed
b= reverse_list([37,2,1,-9]) 
print(b)