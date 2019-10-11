from flask import Flask, render_template
app = Flask(__name__)



def iterateDictionary2():
    arr = []
    users = [
         {'first_name':  'Michael', 'last_name' : 'Jordan'},
         {'first_name' : 'John', 'last_name' : 'Rosales'},
         {'first_name' : 'Mark', 'last_name' : 'Guillen'},
         {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]
    for x in range(0,len(users)):
        a = users[x]
        a['full_name'] = a['first_name'] +" "+ a['last_name']
        arr.append(a)
    return arr

 

@app.route('/')
def index():
 return render_template('HTML_Table.html', foobar=iterateDictionary2())

if __name__ == "__main__":
    app.run(debug=True)