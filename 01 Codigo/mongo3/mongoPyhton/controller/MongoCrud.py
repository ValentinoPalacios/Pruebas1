from controller.MongoConnection import MongoConnection
from model.Store import Store
from pymongo import MongoClient

class MongoCrud:

    def __init__(self):
        db = MongoConnection.get_database()
        self.collection = db["store"]

    # CREATE
    def create(self, store: Store):
        store.price_iva = store.calculate_price_iva()
        self.collection.insert_one({
            "id": store.id,
            "name": store.name,
            "price": store.price,
            "priceIva": store.price_iva
        })

    # READ 
    def read_by_id(self, id):
        d = self.collection.find_one({"id": id})
        if d is None:
            return None

        return Store(
            d["id"],
            d["name"],
            d["price"],
            d["priceIva"]
        )

    # UPDATE
    def update(self, store: Store):
        store.price_iva = store.calculate_price_iva()
        self.collection.update_one(
            {"id": store.id},
            {"$set": {
                "name": store.name,
                "price": store.price,
                "priceIva": store.price_iva
            }}
        )

    # DELETE
    def delete(self, id):
        self.collection.delete_one({"id": id})

    def read_all(self):
        stores = []

        cursor = self.collection.find()  # 👈 find(), NO find_one()

        for d in cursor:
            store = Store(
                d["id"],
                d["name"],
                d["price"],
                d["priceIva"]
            )
            stores.append(store)

        return stores

