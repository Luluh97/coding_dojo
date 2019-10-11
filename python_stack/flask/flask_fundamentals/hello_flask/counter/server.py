from flask import Flask, render_template,request, redirect, session

app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe'


@app.route('/')
def count():
	if "counter" in session:
		session["counter"] += 1
	else:
		session["counter"] = 0
	return render_template('index.html', counter = session["counter"])

@app.route('/destroy_session')
def destroy_session():
    session.clear()
    return redirect ('/')

@app.route('/reset', methods=['POST'])
def reset():
    session['counter'] = 0
    return redirect ('/')

@app.route('/add_two', methods=['POST'])
def add_two():
    session['counter'] += 2
    return render_template('index.html', counter = session["counter"])


if __name__ == "__main__":
    app.run(debug=True)