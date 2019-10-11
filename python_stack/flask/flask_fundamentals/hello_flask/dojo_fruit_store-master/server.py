from flask import Flask, render_template, request, redirect
app = Flask(__name__)  

@app.route('/')         
def index():
    return render_template("index.html")

@app.route('/checkout', methods=['POST'])         
def checkout():
    print(request.form)
    num_of_strawberries = request.form['strawberry']
    num_of_raspberries = request.form['raspberry']
    num_of_apples = request.form['apple']
    first_name = request.form['first_name']
    last_name = request.form['last_name']
    student_id = request.form['student_id']
    charge = int(num_of_strawberries)+int(num_of_raspberries)+int(num_of_apples)
    return render_template("checkout.html", strawberry = num_of_strawberries, raspberry = num_of_raspberries, 
    apple = num_of_apples, fname = first_name, lname = last_name, id = student_id, count = charge)

@app.route('/fruits')         
def fruits():
    return render_template("fruits.html")

if __name__=="__main__":   
    app.run(debug=True)    