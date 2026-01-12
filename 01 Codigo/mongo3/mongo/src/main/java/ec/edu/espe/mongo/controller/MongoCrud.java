package ec.edu.espe.mongo.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import ec.edu.espe.mongo.model.Store;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Paulo Ramos
 */
public class MongoCrud {

    MongoDatabase db = MongoConnection.getDatabase();
    MongoCollection<Document> collection = db.getCollection("store");

    public void create(Store store) {

        float iva = store.calculatePriceIva();

        Document doc = new Document("id", store.getId())
                .append("name", store.getName())
                .append("price", store.getPrice())
                .append("priceIva", iva);

        collection.insertOne(doc);
    }

    public Store readById(int id) {

        Document d = collection.find(eq("id", id)).first();

        if (d == null) {
            return null;
        }

        Number priceNumber = d.get("price", Number.class);
        Number priceIvaNumber = d.get("priceIva", Number.class);

        return new Store(
                d.getInteger("id"),
                d.getString("name"),
                priceNumber.floatValue(),
                priceIvaNumber.floatValue()
        );
    }

    public void update(Store store) {

        float iva = store.calculatePriceIva();

        Document updated = new Document("$set",
                new Document("name", store.getName())
                        .append("price", store.getPrice())
                        .append("priceIva", iva)
        );

        collection.updateOne(eq("id", store.getId()), updated);
    }

    public void delete(int id) {
        collection.deleteOne(eq("id", id));
    }

    public List<Store> readAll() {

        List<Store> stores = new ArrayList<>();

        FindIterable<Document> documents = collection.find();

        for (Document d : documents) {

            Number priceNumber = d.get("price", Number.class);
            Number priceIvaNumber = d.get("priceIva", Number.class);

            Store store = new Store(
                    d.getInteger("id"),
                    d.getString("name"),
                    priceNumber.floatValue(),
                    priceIvaNumber.floatValue()
            );

            stores.add(store);
        }

        return stores;
    }

}
