package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBCRUD {
    public void performCRUD() {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // Implement CRUD operations for MongoDB
            MongoDatabase database = mongoClient.getDatabase("your_database_name");
            MongoCollection<Document> collection = database.getCollection("your_collection_name");

            // Insert document
            Document document = new Document("key", "value");
            collection.insertOne(document);

            // Find document
            Document foundDocument = collection.find(new Document("key", "value")).first();
            System.out.println(foundDocument.toJson());

            // Update document
            collection.updateOne(new Document("key", "value"), new Document("$set", new Document("key", "new_value")));

            // Delete document
            collection.deleteOne(new Document("key", "new_value"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

