const Store = require("../model/Store");

class MongoCrud {

  async create(storeData) {
    console.log("DATA RECIBIDA EN CREATE:", storeData);

    const store = new Store(storeData);
    store.priceIva = store.calculatePriceIva();
    return await store.save();
  }

  async readById(id) {
    return await Store.findOne({ id });
  }

  async update(storeData) {
    const updateData = {
      price: storeData.price,
      priceIva: Number((storeData.price * 1.15).toFixed(2))
    };

    if (storeData.name && storeData.name.trim() !== "") {
      updateData.name = storeData.name;
    }

    return await Store.updateOne(
      { id: storeData.id },
      { $set: updateData }
    );
  }

  async delete(id) {
    return await Store.deleteOne({ id });
  }
}

module.exports = MongoCrud;
