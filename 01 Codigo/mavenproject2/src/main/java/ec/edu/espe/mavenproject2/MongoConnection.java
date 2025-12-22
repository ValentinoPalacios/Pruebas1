package ec.edu.espe.mavenproject2;

/**
 *
 * @author Paulo Ramos
 */

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

    private static final String URI = "mongodb://localhost:27017";
    private static MongoClient client;
    private static MongoDatabase database;

    public static MongoDatabase getDatabase() {
        if (database == null) {
            client = MongoClients.create(URI);
            database = client.getDatabase("testDB"); // cambia el nombre cuando quieras
        }
        return database;
    }
}
