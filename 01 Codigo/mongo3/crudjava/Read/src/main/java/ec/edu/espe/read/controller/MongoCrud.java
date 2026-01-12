package ec.edu.espe.read.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import ec.edu.espe.read.model.Store;
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
