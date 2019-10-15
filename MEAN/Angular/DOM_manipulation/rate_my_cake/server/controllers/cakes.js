const mongoose = require('mongoose')
var Cake = mongoose.model('Cake')
var Rate = mongoose.model('Rate')
module.exports = {
    index: function(req, res) {
        Cake.find({})
        .then(cakes => 
            {
                console.log('finding all')
                res.json(cakes)
            })
        .catch(err => res.json(err));
            
    },

    id: function (req, res) {
        let id = req.params.id
        Rate.find({_cake : id})
        .then(data => {
                console.log('got the rate', data)
                res.json(data)
            })
        .catch(err => res.json(err));
    },

    new: function (req, res) {
        var cake = new Cake(req.body);
        cake.save(function (errorsNewMessage) {
            if (errorsNewMessage) {
                res.json(err);
            } else {
                console.log('cake created successfully', cake)
                res.json({cake: cake});
            }
        });
    },

    rate: function (req, res) {
        Cake.findOne({_id: req.params.id}, function(error1, cake){
            var rate = new Rate({
                comment: req.body.comment,
                stars: req.body.stars,
                _cake: cake._id
            });
            rate.save(function (errorsComment1) {
                cake._rate.push(rate);
                cake.save(function(error2){
                    if (errorsComment1) {
                        res.json(err);
                    } else {
                        console.log('rate created successfully', rate)
                        res.json({rate: rate});
                    }
                });
            });
        });
    }
};




