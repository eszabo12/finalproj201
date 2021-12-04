import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Example {
    public static void main(String[] args) {
        // String uri = "mongodb+srv://andrewfy:hyrHuv-gamryx-goxdu8@cluster0.02k5z.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";

        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://andrewfy:hyrHuv-gamryx-goxdu8@cluster0.02k5z.mongodb.net/myFirstDatabase?retryWrites=true&w=majority")) {
            MongoDatabase database = mongoClient.getDatabase("csci201_final");
            MongoCollection<Document> collection = database.getCollection("users");

            CRUD.addUser(collection, "tester2", "password");
        }

    }
}
