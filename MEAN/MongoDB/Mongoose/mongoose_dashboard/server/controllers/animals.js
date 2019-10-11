const mongoose = require('mongoose')
var Dashboard = mongoose.model('Dashboard')
module.exports = {
    index: function(req, res) {
        Dashboard.find()
        .then(data => res.render("all", {all: data}))
        .catch(err => res.json(err));
            
    },
    new: function(req, res) {
        Dashboard.find()
        .then(data => res.render("new", {dash: data}))
        .catch(err => res.json(err));
    },
    create: function(req, res) {
        const dash = new Dashboard(req.body);
        dash.save()
            .then(data => {
                console.log('animal created: ', data);
                res.redirect('/mongoose/new');
            })
            .catch(err => {
                console.log("We have an error!", err);
                for (var key in err.errors) {
                    req.flash('registration', err.errors[key].message);
                }
                res.redirect('/mongoose/new');
            });
    },
    info: function(req, res) {
        Dashboard.findOne({_id : req.params.id})
        .then(data => {
                res.render("info", {info: data});
            })
        .catch(err => res.json(err));
    },
    find: function(req, res) {
        Dashboard.findOne({_id : req.params.id})
            .then(data => {
                    res.render("edit", {edit: data});
                })
            .catch(err => res.json(err));
    },
    update: function(req, res) {
        Dashboard.update({_id : req.params.id}, {animal: req.body.animal,
            family: req.body.family, order: req.body.order, class: req.body.class
            })
                .then(data => {
                    res.redirect('/');
                })
                .catch(err => {
                    console.log("We have an error!", err);
                    for (var key in err.errors) {
                        req.flash('registration', err.errors[key].message);
                    }
                    res.redirect('/mongoose/new');
                });
    },
    remove: function(req, res) {
        Dashboard.findOneAndRemove({_id : req.params.id})
            .then(data => {
                res.redirect('/');
            })
            .catch(err => {
                console.log("We have an error!", err);
                for (var key in err.errors) {
                    req.flash('registration', err.errors[key].message);
                }
                res.redirect('/mongoose/new');
            });
    },
};
