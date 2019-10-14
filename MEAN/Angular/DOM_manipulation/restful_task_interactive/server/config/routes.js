var tasks = require('../controllers/tasks.js');

module.exports = function(app){
        app.get('/tasks', (req, res) => { 
            tasks.index(req, res);   
        }),

        app.get('/tasks/id', (req, res) => { 
            tasks.id(req, res);   
        })
        

    }

    