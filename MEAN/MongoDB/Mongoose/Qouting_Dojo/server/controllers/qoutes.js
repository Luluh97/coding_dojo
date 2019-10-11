const mongoose = require('mongoose')
var Qoute = mongoose.model('Qoute')
module.exports = {
    index: function(req, res) {
        Qoute.find()
        .then(data => res.render("index", {qoutes: data}))
        .catch(err => res.json(err));
            
    },
    create_qoute: function(req, res) {
        const qoute = new Qoute(req.body);
        qoute.save()
            .then(data => {
                console.log('qoute created: ', data);
                res.redirect('/');
            })
            .catch(err => {
                console.log("We have an error!", err);
                for (var key in err.errors) {
                    req.flash('registration', err.errors[key].message);
                }
                res.redirect('/');
            });
    },
    all_qoutes: function(req, res) {
        Qoute.find()
        .then(data => res.render("qoutes", {qoutes: data}))
        .catch(err => res.json(err));
    }
};