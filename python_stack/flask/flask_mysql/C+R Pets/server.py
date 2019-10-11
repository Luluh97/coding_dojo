from flask import Flask, render_template, request, redirect,url_for
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'postgresql://postgres:1997@localhost/pets'
db = SQLAlchemy(app)

class pets(db.Model):
    pet_id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(45), unique=True)
    type =db.Column(db.String(45))
    created_at = db.Column(db.DateTime, server_default=db.func.now())
    updated_at = db.Column(db.DateTime, server_default=db.func.now(), server_onupdate=db.func.now())

    def __init__(self,name, type):
        self.name = name
        self.type = type
    
    def __reper__(self):
        return '<pets %r>' % self.name


@app.route('/')
def index():
    myPet = pets.query.all()
    return render_template('index.html', myPet = myPet)

@app.route('/add_pet', methods=['POST'])
def add_pet():
    pet = pets(request.form['name'], request.form['type'])
    db.session.add(pet)
    db.session.commit()
    return redirect(url_for('index'))

if __name__ == "__main__":
    app.run(debug=True)