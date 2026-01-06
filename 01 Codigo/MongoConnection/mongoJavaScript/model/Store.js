const mongoose = require("mongoose");

const StoreSchema = new mongoose.Schema(
  {
    id: Number,
    name: String,
    price: Number,
    priceIva: Number,
  },
  {
    versionKey: false
  }
);

StoreSchema.methods.calculatePriceIva = function () {
  return this.price * 1.15;
};

module.exports = mongoose.model("Store", StoreSchema, "store");
