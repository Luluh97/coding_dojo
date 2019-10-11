# ####### first ########

# x = [ [5,2,3], [10,8,9] ] 
# students = [
#      {'first_name':  'Michael', 'last_name' : 'Jordan'},
#      {'first_name' : 'John', 'last_name' : 'Rosales'}
# ]
# sports_directory = {
#     'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
#     'soccer' : ['Messi', 'Ronaldo', 'Rooney']
# }
# z = [ {'x': 10, 'y': 20} ]

# 1
# a = x[1]
# a[0] = 15
# print(x)

# 2
# a = students[0]
# a['last_name'] = 'Bryant'
# print(students)

# 3
# a = sports_directory ['soccer']
# a[0] = 'Andres'
# print(sports_directory)

# 4
# a = z[0] 
# a['y'] = 30
# print(z)

# ####### second ########

# students = [
#          {'first_name':  'Michael', 'last_name' : 'Jordan'},
#          {'first_name' : 'John', 'last_name' : 'Rosales'},
#          {'first_name' : 'Mark', 'last_name' : 'Guillen'},
#          {'first_name' : 'KB', 'last_name' : 'Tonel'}
#     ]

# def iterateDictionary(students):
#     for x in range(0, len(students)):
#         a = students[x]
#         print("first_name - ", a['first_name'])
#         print("last - ", a['last_name'])

# iterateDictionary(students)

####### third ########
students = [
         {'first_name':  'Michael', 'last_name' : 'Jordan'},
         {'first_name' : 'John', 'last_name' : 'Rosales'},
         {'first_name' : 'Mark', 'last_name' : 'Guillen'},
         {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]

def iterateDictionary2(key_name, some_list):
    for x in range(0,len(students)):
        a = students[x]
        print(a[key_name])

iterateDictionary2('last_name',students)

# ####### forth ########

# dojo = {
#    'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
#    'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
# }


# def printInfo(dojo):
#     for key,val in dojo.items():
#         a = dojo [key]
#         print (len(a),key.upper())
#         for v in val :
#             print(v)
# printInfo(dojo)


# arr = [1,3,5,7]
# arr[0], arr[1] = arr[1], arr[0]
# print(arr)