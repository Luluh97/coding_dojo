const express = require("express");
const app = express();
const server = app.listen(8000);
const mongoose = require('mongoose');
const flash = require('express-flash');
const session = require('express-session');
const bcrypt = require('bcrypt');
var Schema = mongoose.Schema
app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');


app.use(express.urlencoded({extended: true}));
app.use(flash());
app.use(session({
  secret: 'keyboardkitteh',
  resave: false,
  saveUninitialized: true,
  cookie: { maxAge: 60000 }
}));

mongoose.connect('mongodb://localhost/message_board', {
useUnifiedTopology: true,
useNewUrlParser: true,
});

const UserSchema = new mongoose.Schema({
    first_name: {type: String, required: true},
    last_name: {type: String, required: true},
    email: {type: String, required: [true, ], match: /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/},
    password: {type: String, required: true},
    birthday: {type: String, required: true}},
    {timestamps: true});

   const User = mongoose.model('User', UserSchema);


app.get('/', (req, res) => {  
    res.render("index")

});

app.post('/register', (req, res) => {
    bcrypt.hash(req.body.password, 10)
    .then(hashed => {
        const user = new User({
            first_name: req.body.fname,
            last_name: req.body.lname,
            birthday: req.body.birthday,
            email: req.body.email,
            password: hashed,
        });
        user.save()
            .then(data => {
                console.log('user registered: ', data);
                res.redirect('/');
            })
            .catch(err => {
                console.log("ERROR!!!!!!!!!!!!", err);
                for (var key in err.errors) {
                    req.flash('registration', err.errors[key].message);
                }
                res.redirect('/');
            });
    })
    .catch(err => {
        console.log("ERROR!!!!!!!!!!!!", err);
        for (var key in err.errors) {
            req.flash('registration', err.errors[key].message);
        }
        res.redirect('/');
    });

    
});

app.post('/login', (req, res) => {
    User.findOne({email:req.body.email})
        .then(user => {
            bcrypt.compare(req.body.password, user.password)
            .then(result => {
                req.session.user_id = user._id;
                req.session.email = user.email;
                console.log('id: '+req.session.user_id+' email:'+req.session.email)
                res.redirect('/');
            })
            .catch(error => {
                console.log("user not registered", err);
                for (var key in err.errors) {
                    req.flash('registration', err.errors[key].message);
                }
                res.redirect('/');
            })
        })
        .catch(err => {
            console.log("user not registered", err)
            for (var key in err.errors) {
                req.flash('registration', err.errors[key].message)
            }
            res.redirect('/')
        })
    })







