from flask import Flask, render_template,request, redirect, session
import random

app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe'

@app.route('/')
def index():
    if 'gold' in session:
        session['gold'] = session['gold']
    else:
        session['gold'] = 0
    return render_template('index.html', gold = session['gold'])

@app.route('/process_money', methods=['POST'])
def process_money():
    if "activity" not in session:
        session['activity'] = []

    if request.form['place'] == 'farm':
        session['random'] = random.randrange(10, 21)
        session['gold'] += session['random']
        session['activity'].append("Earned "+str(session['random'])+" from the farm")

    if request.form['place'] == 'cave':
        session['random'] = random.randrange(5, 11)
        session['gold'] += session['random']
        session['activity'].append("Earned "+str(session['random'])+" from the cave")

    if request.form['place'] == 'house':
        session['random'] = random.randrange(2, 6)
        session['gold'] += session['random']
        session['activity'].append("Earned "+str(session['random'])+" from the house")

    if request.form['place'] == 'casino':
        session['random'] = random.randrange(-50, 51)
        session['gold'] += session['random']
        if session['random'] < 0:
            session['activity'].append("Lost "+str(-1*session['random'])+" from the casino")
        else:
            session['activity'].append("Earned "+str(session['random'])+" from the casino")   
    
    return redirect('/')

@app.route('/reset', methods=['POST'])
def reset():
    session['gold'] = 0
    session['activity'] = []
    return redirect ('/')

if __name__ == "__main__":
    app.run(debug=True)