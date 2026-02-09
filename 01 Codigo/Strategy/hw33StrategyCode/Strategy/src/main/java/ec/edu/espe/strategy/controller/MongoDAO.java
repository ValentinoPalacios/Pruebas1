package ec.edu.espe.strategy.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.Arrays;

/**
 *
 * @author Paulo Ramos
 */

public class MongoDAO {
public boolean save(int[] originalNumbers, int[] sortedNumbers) {
        try {
            MongoDatabase db = MongoConnection.getConnection();
            MongoCollection<Document> collection = db.getCollection("Strategy");

            Document doc = new Document()
                    .append("Numbers", Arrays.asList(Arrays.stream(originalNumbers).boxed().toArray(Integer[]::new)));
            collection.insertOne(doc);
            return true;

        } catch (Exception e) {
            System.err.println("Error MongoDB: " + e.getMessage());
            return false;
        }
    }
}
