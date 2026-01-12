
package ec.edu.espe.create.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.create.model.Store;
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
}
