const express = require("express");
const app = express();
const server = app.listen(1337);
const mongoose = require('mongoose');
const flash = require('express-flash');
const session = require('express-session');

app.set('view engine', 'ejs');
app.set('views', __dirname + '/client/views');


app.use(express.urlencoded({extended: true}));
app.use(flash());
app.use(session({
  secret: 'keyboardkitteh',
  resave: false,
  saveUninitialized: true,
  cookie: { maxAge: 60000 }
}));

mongoose.connect('mongodb://localhost/mongofirst', {
useUnifiedTopology: true,
useNewUrlParser: true,
});

require('./server/config/mongoose.js');
require('./server/config/routes.js')(app);
