var cakes = require('../controllers/cakes.js');

module.exports = function(app){
        app.get('/cakes', (req, res) => { 
            cakes.index(req, res);   
        }),

        app.get('/cakes/:id', (req, res) => { 
            cakes.id(req, res);   
        })

        app.post('/cakes', (req, res) => { 
            cakes.new(req, res);   
        })

        app.post('/rates/:id', (req, res) => { 
            cakes.rate(req, res);   
        })
        

    }

    