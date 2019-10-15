const express = require("express");
const app = express();
const server = app.listen(8000);
const mongoose = require('mongoose');
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());
app.use(express.json());
mongoose.Promise = global.Promise;


mongoose.connect('mongodb://localhost/cake_db', {
useUnifiedTopology: true,
useNewUrlParser: true,
});

const   CakeSchema = new mongoose.Schema({
    name: {type: String},
    img: { type: String}},
    {timestamps: true});

   const Cake = mongoose.model('Cake', CakeSchema);



app.get('/cakes', (req, res) => {
    Cake.find()
        .then(tasks => res.json({cake:tasks}))
        .catch(err => res.json(err));
}) 

// app.get('/:id/', function (req, res) {
//     let id = req.params.id
//     Task.find({_id : id})
//     .then(data => {
//             res.json({data: data});
//         })
//     .catch(err => res.json(err));
// });

app.post('/cakes', function (req, res) {
    var cake = new Cake({ name: req.body.name, img: req.body.img});
    cake.save(function (errorsNewMessage) {
        if (errorsNewMessage) {
            res.json(err);
        } else {
            console.log('cake created successfully', cake)
            res.json({cake: cake});
        }
    });
});


// app.put('/update/:id/', function (req, res, t, d) {
//     Task.updateOne({_id : req.params.id}, {title: t,
//         description: d
//         })
//             .then(data => {
//                 res.json({data: data});
//             })
//             .catch(err => {
//                 console.log("We have an error!", err);
//                 for (var key in err.errors) {
//                     req.flash('registration', err.errors[key].message);
//                 }
//                 res.json(err);
//             });
// });


app.delete('/remove/:id/', function (req, res) {
    Task.findOneAndDelete({id : req.params._id})
    .then(data => {
        console.log('task deleted:')
        res.json({data: data})
    })
    .catch(err => {

        res.json(err);
    });
});
