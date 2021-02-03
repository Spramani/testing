const mongoose = require('mongoose');

const mod = new mongoose.Schema({
    name: String,
    address: String,
    city: String,

});


const models = new mongoose.model('models', mod);

module.exports = models;