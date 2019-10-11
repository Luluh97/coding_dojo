from flask import Flask, render_template
app = Flask(__name__)

@app.route('/play')
def play():
    return render_template('playground1.html')

@app.route('/play/<x>')
def num(x):
    return render_template('playground2.html',times=int(x))

@app.route('/play/<x>/<color>')
def color(x, color):
    return render_template('playground3.html', times = int(x), background = color)
     
if __name__ == "__main__":
    app.run(debug=True)