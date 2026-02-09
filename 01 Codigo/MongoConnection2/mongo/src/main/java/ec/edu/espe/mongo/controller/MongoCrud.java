package ec.edu.espe.mongo.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import ec.edu.espe.mongo.model.Store;
import org.bson.Document;

/**
 *
 * @author Paulo Ramos
 */
public class MongoCrud {

    MongoDatabase db = MongoConnection.getDatabase();
    MongoCollection<Document> collection = db.getCollection("store");

    // CREATE
    public void create(Store store) {

        float iva = store.calculatePriceIva();

        Document doc = new Document("id", store.getId())
                .append("name", store.getName())
                .append("price", store.getPrice())
                .append("priceIva", iva);

        collection.insertOne(doc);
    }

    // READ id
    public Store readById(int id) {

        Document d = collection.find(eq("id", id)).first();

        if (d == null) {
            return null;
        }

        return new Store(
                d.getInteger("id"),
                d.getString("name"),
                d.getDouble("price").floatValue(),
                d.getDouble("priceIva").floatValue()
        );
    }

    // UPDATE
    public  void update(Store store) {

        float iva = store.calculatePriceIva();

        Document updated = new Document("$set",
                new Document("name", store.getName())
                        .append("price", store.getPrice())
                        .append("priceIva", iva)
        );

        collection.updateOne(eq("id", store.getId()), updated);
    }

    // DELETE
    public void delete(int id) {
        collection.deleteOne(eq("id", id));
    }
}
