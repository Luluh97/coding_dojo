const mongoose = require('mongoose');

const DashboardSchema = new mongoose.Schema({
    animal: {type: String, required: true},
    animal: {type: String, required: true},
    family: {type: String, required: true}, 
    order: {type: String, required: true},
    class: {type: String, required: true}},
    {timestamps: true});

   const Dashboard = mongoose.model('Dashboard', DashboardSchema);


