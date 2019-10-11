const express = require("express");
const app = express();
const server = app.listen(1337);
app.use(express.static(__dirname + "/public"));
const io = require('socket.io')(server);


app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');
app.use(express.urlencoded({extended: true}));




io.on('connection', function (socket) { 
    socket.on('posting_form', function(data){
        var random_number = Math.floor(1+Math.random()*1000)
        socket.emit('update', { response: data });
        socket.emit('random_number', { response: random_number });
    });
      
  });


app.get('/', (req, res) => {
    res.render('survey')
});

// app.post('/result', (req, res) => {
//     name = req.body.name
//     location = req.body.location
//     language = req.body.language
//     comment = req.body.comment
    
//     res.render('result', {name: name, location: location, language: language, comment: comment});
// });

