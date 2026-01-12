const Store = require("../model/Store");

class MongoCrud {

  async create(store) {
    store.priceIva = store.price * 1.12;
    return await Store.create(store);
  }

  async readAll() {
    const stores = await Store.find();
    return stores.map(s => ({
      id: s.id,
      name: s.name,
      price: s.price,
      priceIva: s.price * 1.12
    }));
  }

  async readById(id) {
    const s = await Store.findOne({ id });
    if (!s) return null;

    return {
      id: s.id,
      name: s.name,
      price: s.price,
      priceIva: s.price * 1.12
    };
  }

  async update(store) {
    await Store.updateOne(
      { id: store.id },
      { $set: { name: store.name, price: store.price } }
    );
    return true;
  }

  async delete(id) {
    await Store.deleteOne({ id });
    return true;
  }
}

module.exports = MongoCrud;

