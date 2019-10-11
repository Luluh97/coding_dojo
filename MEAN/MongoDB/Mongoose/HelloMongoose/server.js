const express = require("express");
const app = express();
const server = app.listen(1337);
app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');
app.use(express.urlencoded({extended: true}));

const mongoose = require('mongoose');
const flash = require('express-flash');
app.use(flash());
const session = require('express-session');
app.use(session({
  secret: 'keyboardkitteh',
  resave: false,
  saveUninitialized: true,
  cookie: { maxAge: 60000 }
}))

mongoose.connect('mongodb://localhost/mongofirst', {
useUnifiedTopology: true,
useNewUrlParser: true,
});

const UserSchema = new mongoose.Schema({
    name: {type: String, required: true},
    age: {type: String, required: true}
   })
   // create an object to that contains methods for mongoose to interface with MongoDB
   const User = mongoose.model('User', UserSchema);


app.get('/', (req, res) => {  
    User.find()
        .then(data => res.render("index", {users: data}))
        .catch(err => res.json(err));
});

app.post('/users', (req, res) => {
    const user = new User(req.body);
    user.save()
        .then(() => res.redirect('/'))
        .catch(err => {
            console.log("We have an error!", err);
            // adjust the code below as needed to create a flash message with the tag and content you would like
            for (var key in err.errors) {
                req.flash('registration', err.errors[key].message);
            }
            res.redirect('/');
        });
});

