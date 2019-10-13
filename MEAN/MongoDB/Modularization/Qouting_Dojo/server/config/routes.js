var quotes = require('../controllers/tasks.js');

module.exports = function(app){
        app.get('/', (req, res) => { 
            
            quotes.index(req, res);
            
        })
        
        app.get('/qoutes', (req, res) => { 
            quotes.all_qoutes(req, res); 

        })
        
        
        app.post('/qoutes', (req, res) => {
            quotes.create_qoute(req, res); 
        
        })
    }