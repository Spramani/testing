const express = require('express');
const { model } = require('mongoose');
const router = new express.Router();
const models = require('../model/mymodel');


router.get('/', (req, res) => {
    models.find((err, data) => {
        if (!err) {
            res.render('index.ejs', { data: data });
            console.log(data);
        }
    });
});


router.post('/adddata', (req, res) => {
    const sname = req.body.sname;
    const address = req.body.address;
    const city = req.body.city;

    const one = new models({
        name : sname,
        address : address,
        city : city,
    });
    one.save((err, data) => {
        if (!err) {
            console.log(data);
        }
    });

    res.redirect('/');

});


// data get
router.get('/editdata', (req, res) => {
  const id = req.query.id;
  models.findById(id, (err, data) => {
    if (!err) {
      res.render('edit', { data: data });
    }
  });
});


// data update
router.post('/updatedata', (req, res) => {
  const id = req.query.id;
  models.findByIdAndUpdate(
    id,
    {
      sname: req.body.name,
      address: req.body.address,
      city: req.body.city,
    },
    (err, data) => {
      if (!err) {
        console.log('updated');
        res.redirect('/');
      }
    }
  );
});

module.exports = router;