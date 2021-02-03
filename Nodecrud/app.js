//express set

const express = require('express');
const app = express();
const path = require('path');
const bodyparser = require('body-parser');

//import 
const router = require('./routers/routes')
const connectdb = require('./db/mydatabase');

//ejs and view 
const npath = path.join(__dirname, 'views');
app.set('view engine', 'ejs');
app.set('views', npath);  

//body parser setup

app.use(bodyparser.urlencoded({ extended: false }));
app.use(bodyparser.json());


connectdb();
app.use(router);

app.listen(3000, () => {
    console.log('App listening on port 3000!');
});