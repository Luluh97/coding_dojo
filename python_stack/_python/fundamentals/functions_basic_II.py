def countDown(num):
    arr = [];
    for x in range(num,0,-1):
        arr.append(x)
    return arr;

b=countDown(5)
pirint(b)
