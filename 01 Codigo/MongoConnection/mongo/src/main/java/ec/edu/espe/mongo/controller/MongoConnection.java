package ec.edu.espe.mongo.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Paulo Ramos
 */
public class MongoConnection {
    private static MongoClient client;
    private static MongoDatabase database;

    public static MongoDatabase getDatabase() {
        if (client == null) {
            client = MongoClients.create("mongodb+srv://Paulo:paulo2004@cluster0.9uxqgih.mongodb.net/?appName=Cluster0");
            database = client.getDatabase("Stores");
        }
        return database;
    }
}
