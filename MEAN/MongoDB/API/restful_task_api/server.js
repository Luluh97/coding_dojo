const express = require("express");
const app = express();
const server = app.listen(8000);
const mongoose = require('mongoose');
app.use(express.json());

mongoose.connect('mongodb://localhost/restful_task_api', {
useUnifiedTopology: true,
useNewUrlParser: true,
});

const   TaskSchema = new mongoose.Schema({
    title: {type: String},
    description: {type: String},
    completed: {type: Boolean}},
    {timestamps: true});

   const Task = mongoose.model('Task', TaskSchema);

//GET: Retrieve all Tasks
app.get('/', (req, res) => {
    Task.find()
        .then(tasks => res.json(tasks))
        .catch(err => res.json(err));
}) 

//GET: Retrieve a Task by ID
app.get('/:id/', function (req, res) {
    Task.find({_id : req.params.id})
    .then(data => {
            res.json(data);
        })
    .catch(err => res.json(err));
});

//POST: Create a Task
app.get('/new/:title/:description/:completed', function (req, res) {
    var task = new Task({ title: req.params.title, description: req.params.description, completed: req.params.completed });
    task.save(function (errorsNewMessage) {
        if (errorsNewMessage) {
            res.json(err);
        } else {
            console.log('task created', task)
            res.json(task);
        }
    });
});

//PUT: Update a Task by ID
app.put('/update/:id/', function (req, res) {
    req.body.updated_at = new Date();
    Task.update({_id : req.params.id}, {$set : req.body}, function(err){
        if(err){
            console.log(err)
        }
        else{
            Task.findOne({_id : req.params.id}, function(err, task){
                if(err){
                    console.log(err)
                }
                else{
                    res.json(task)
                }
            })
        }
    })
});

//DELETE: Delete a Task by ID
app.get('/remove/:id/', function (req, res) {
    Task.findOneAndRemove({id : req.params._id})
    .then(data => {
        console.log('task deleted:', data)
        res.json(data);
    })
    .catch(err => {

        res.json(err);
    });
});
