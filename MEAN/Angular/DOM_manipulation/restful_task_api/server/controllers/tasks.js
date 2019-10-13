const mongoose = require('mongoose')
var Task = mongoose.model('Task')
module.exports = {
    index: function(req, res) {
        Task.find({})
        .then(tasks => res.json(tasks))
        .catch(err => res.json(err));
            
    },

    id: function (req, res) {
        let id = req.params.id
        Task.find({_id : id})
        .then(data => {
                res.json({data: data});
            })
        .catch(err => res.json(err));
    }

};



