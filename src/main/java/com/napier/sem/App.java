package com.napier.sem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        // Connect to MongoDB
        try (MongoClient mongoClient = new MongoClient("mongo-dbserver")) {
            // Get a database - will create when we use it
            MongoDatabase database = mongoClient.getDatabase("mydb");
            // Get a collection from the database
            MongoCollection<Document> collection = database.getCollection("test");
            // Create a document to store
            Document doc = new Document("name", "Sein Lei")
                    .append("class", "Software Engineering Methods")
                    .append("year", "2024")
                    .append("result", new Document("CW", 95).append("EX", 85));
            // Add document to collection
            collection.insertOne(doc);

            // Check document in collection
            Document myDoc = collection.find().first();
            System.out.println(myDoc.toJson());
        }
        catch (Exception e) {
            logger.error("An error occurred", e);
        }
    }
}
