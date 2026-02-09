const mongoose = require("mongoose");

const NumberSchema = new mongoose.Schema({
  numbers: {
    type: [Number],
    required: true
  }
});

module.exports = mongoose.model("Numbers", NumberSchema);
