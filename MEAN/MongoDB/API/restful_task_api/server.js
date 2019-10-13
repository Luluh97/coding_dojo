const express = require("express");
const app = express();
const server = app.listen(8000);
const mongoose = require('mongoose');
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());
app.use(express.json());
mongoose.Promise = global.Promise;


mongoose.connect('mongodb://localhost/restful_task_api', {
useUnifiedTopology: true,
useNewUrlParser: true,
});

const   TaskSchema = new mongoose.Schema({
    title: {type: String},
    description: {type: String, default:''},
    completed: {type: Boolean, default:true}},
    {timestamps: true});

   const Task = mongoose.model('Task', TaskSchema);



app.get('/', (req, res) => {
    Task.find()
        .then(tasks => res.json({tasks:tasks}))
        .catch(err => res.json(err));
}) 

app.get('/:id/', function (req, res) {
    let id = req.params.id
    Task.find({_id : id})
    .then(data => {
            res.json({data: data});
        })
    .catch(err => res.json(err));
});

app.get('/new/:title/:description/:completed', function (req, res) {
    var task = new Task({ title: req.params.title, description: req.params.description, completed: req.params.completed });
    task.save(function (errorsNewMessage) {
        if (errorsNewMessage) {
            res.json(err);
        } else {
            console.log('task created successfully')
            res.json({task: task});
        }
    });
});


app.put('/update/:id/', function (req, res) {
    Task.update({_id : req.params.id}, {title: req.body.title,
        description: req.body.description, completed: req.body.completed
        })
            .then(data => {
                res.json({data: data});
            })
            .catch(err => {
                console.log("We have an error!", err);
                for (var key in err.errors) {
                    req.flash('registration', err.errors[key].message);
                }
                res.json(err);
            });
});


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
