var animals = require('../controllers/animals.js');

module.exports = function(app){
    app.get('/', (req, res) => {  
        animals.index(req, res);
    });
    
    app.get('/mongoose/new', (req, res) => {  
        animals.new(req, res);
    });
    
    app.post('/mongooses', (req, res) => {
        animals.create(req, res);
    });
    
    app.get('/mongooses/:id', (req, res) => {  
        animals.info(req, res);
    });
    
    app.get('/mongooses/edit/:id', (req, res) => {  
        animals.find(req, res);
    });
    
    app.post('/mongooses/:id', (req, res) => {
        animals.update(req, res);
    });
    
    app.post('/mongooses/destroy/:id', (req, res) => {
        animals.remove(req, res);
    });
    }

