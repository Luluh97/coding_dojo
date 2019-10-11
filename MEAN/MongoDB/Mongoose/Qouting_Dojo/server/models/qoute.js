var mongoose = require('mongoose');
const QouteSchema = new mongoose.Schema({
    name: {type: String, required: true},
    qoute: {type: String, required: true}}, 
    {timestamps: true});

   const Qoute = mongoose.model('Qoute', QouteSchema);