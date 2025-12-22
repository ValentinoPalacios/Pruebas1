package ec.edu.espe.mavenproject2;


/**
 *
 * @author Paulo Ramos
 */
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoCrud {

    private MongoCollection<Document> collection;

    public MongoCrud(String collectionName) {
        this.collection = MongoConnection
                .getDatabase()
                .getCollection(collectionName);
    }

    // CREATE
    public void insert(Document doc) {
        collection.insertOne(doc);
    }

    // READ ALL
    public List<Document> findAll() {
        List<Document> list = new ArrayList<>();
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                list.add(cursor.next());
            }
        }
        return list;
    }

    // READ BY FIELD
    public Document findOne(String field, Object value) {
        return collection.find(new Document(field, value)).first();
    }

    // UPDATE
    public boolean update(String field, Object value, Document newValues) {
        UpdateResult result = collection.updateOne(
                new Document(field, value),
                new Document("$set", newValues)
        );
        return result.getModifiedCount() > 0;
    }

    // DELETE
    public boolean delete(String field, Object value) {
        DeleteResult result = collection.deleteOne(
                new Document(field, value)
        );
        return result.getDeletedCount() > 0;
    }
}
