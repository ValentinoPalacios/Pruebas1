package ec.edu.espe.strategy.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Paulo Ramos
 */

public class MongoConnection {
    
    private static final String URI = "mongodb+srv://Paulo:paulo2004@cluster0.9uxqgih.mongodb.net/?appName=Cluster0";
        
    private static final String DATABASE = "Strategy";

    private static MongoClient mongoClient = null;

    public static MongoDatabase getConnection() {
        try {
            if (mongoClient == null) {
                mongoClient = MongoClients.create(URI);               
            }
            return mongoClient.getDatabase(DATABASE);

        } catch (Exception e) {
            System.err.println("Error Database: " + e.getMessage());
            return null;
        }
    }
}

    
