from flask import Flask, render_template, request, redirect,url_for
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'postgresql://postgres:1997@localhost/users_db'
db = SQLAlchemy(app)

class users(db.Model):
    user_id = db.Column(db.Integer, primary_key=True)
    first_name = db.Column(db.String(45))
    last_name = db.Column(db.String(45))
    email = db.Column(db.String(45), unique=True)
    created_at = db.Column(db.DateTime, server_default=db.func.now())
    updated_at = db.Column(db.DateTime, server_default=db.func.now(), server_onupdate=db.func.now())

    def __init__(self,first_name, last_name,email):
        self.first_name = first_name
        self.last_name = last_name
        self.email = email
    
    def __reper__(self):
        return '<users %r>' % self.first_name


@app.route('/users/new')
def adding_user_temp():
    users_info = users.query.all()
    return render_template('index.html')

@app.route('/users/create', methods=['POST'])
def create():
    users_info = users(request.form['first_name'], request.form['last_name'], request.form['email'])
    db.session.add(users_info)
    db.session.commit()
    return redirect('/users/new')


@app.route('/users/<id>')
def add_user(id):
    user_to_add = users.query.filter_by(user_id = id ).first()
    db.session.commit()
    return render_template('index2.html', user = user_to_add)

@app.route('/users')
def display_users():
    all_users = users.query.all()
    return render_template('index1.html', users = all_users)

@app.route('/users/<id>/edit')
def edit_user(id):
    user_to_edit = users.query.filter_by(user_id=id).all()
    db.session.commit()
    return render_template('index3.html', user = user_to_edit)

@app.route('/users/<id>/update', methods=['POST'])
def update_user(id):
   user_to_update = users.query.filter_by(user_id=id).all()
   user_to_update.first_name = request.form['first_name']
   user_to_update.last_name = request.form['last_name']
   user_to_update.email = request.form['email']
   db.session.commit()
   return redirect('/users/<'+id+'>')

@app.route('/users/<id>/destroy')
def delete_user(id):
    user_to_delete = users.query.filter_by(user_id=id).all()
    db.session.delete(user_to_delete)
    db.session.commit()
    return redirect('/users')
 
if __name__ == "__main__":
    app.run(debug=True)