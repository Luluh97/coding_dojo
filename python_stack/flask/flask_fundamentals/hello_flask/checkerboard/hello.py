from flask import Flask, render_template   
app = Flask(__name__)  


@app.route('/')
def checkerboard1():
    
    return  render_template("index.html", x = 8, y = 8 )   


@app.route('/<x>')
def checkerboard2(x):
    num = int(x)
    return  render_template("index.html", x = 8, y = num )   


@app.route('/<x>/<y>')
def checkerboard3(x,y):
  inum1 = int(x)
  inum2 = int(y)
  return render_template("index.html", x = inum1, y = inum2 )


if __name__=="__main__":  
    app.run(debug= True) 
    