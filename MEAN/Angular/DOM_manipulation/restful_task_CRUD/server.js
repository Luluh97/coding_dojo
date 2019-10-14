const express = require("express");
const app = express();
const server = app.listen(8000);
const mongoose = require('mongoose');
var bodyParser = require('body-parser');
const session = require('express-session');

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());
app.use(express.json());
app.use(express.static( __dirname + '/public/dist/public' ));
app.use(session({
    secret: 'keyboardkitteh',
    resave: false,
    saveUninitialized: true,
    cookie: { maxAge: 60000 }
  }))

  
mongoose.Promise = global.Promise;


mongoose.connect('mongodb://localhost/restful_task_api', {
useUnifiedTopology: true,
useNewUrlParser: true,
});

require('./server/config/mongoose.js');
require('./server/config/routes.js')(app);
require('./server/models/task.js') //needed?