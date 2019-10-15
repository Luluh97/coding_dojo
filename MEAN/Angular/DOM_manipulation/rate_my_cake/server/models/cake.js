var mongoose = require('mongoose');
var Schema = mongoose.Schema
var  CakeSchema = new mongoose.Schema({
    name: {type: String},
    img: { type: String},
    _rate: [{type: Schema.Types.ObjectId, ref: 'Rate' }]},    {timestamps: true});

   var Cake = mongoose.model('Cake', CakeSchema);

var  RateSchema = new mongoose.Schema({
    stars: {type: String},
    comment: { type: String},
    _cake: {type: Schema.Types.ObjectId, ref: 'Cake' }},
    {timestamps: true});

   var Rate = mongoose.model('Rate', RateSchema);
