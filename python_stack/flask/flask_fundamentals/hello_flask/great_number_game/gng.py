from flask import Flask, render_template,request, redirect, session
import random

app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe'


@app.route('/')
def count():
    session['rand'] = random.randint(1, 100)
    print(session['rand'])
    return render_template('index.html')
		

@app.route('/result', methods=['POST'])
def get_result():
    session['number'] = request.form['answer']
    
    if int(session['number']) < session['rand']:
        result = "too low"
        return render_template('index1.html', result = result)
    if int(session['number']) > session['rand']:
        result = "too high"
        return render_template('index1.html', result = result)
    if int(session['number']) == session['rand']:
        result = "Correct"
        return render_template('index1.html', result = result)


if __name__ == "__main__":
    app.run(debug=True)