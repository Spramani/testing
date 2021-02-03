const mongoose = require('mongoose');

//mongoose database

const connectdb = () => {
    mongoose.connect('mongodb://localhost:27017/prec1',{
        useNewUrlParser: true,
        useUnifiedTopology: true,
    })
    .then(() => {
        console.log('DB connect');
    })
    .catch((e) => {
        console.log(e);
    });
};

module.exports = connectdb;

