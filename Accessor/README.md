

Connect to the database with the following code:

        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://andrewfy:hyrHuv-gamryx-goxdu8@cluster0.02k5z.mongodb.net/myFirstDatabase?retryWrites=true&w=majority")) {
            MongoDatabase database = mongoClient.getDatabase("csci201_final");
            MongoCollection<Document> collection = database.getCollection("users");

            // All database functions go here
            // For example, if we want to add a user to the database with username "tester1" and password "password" 
            CRUD.addUser(collection, "tester1", "password");
        }

Call functions with CRUD.<function> after connecting to the database. Functions need to be called in the same code block as the connection to database.

To find if a username already exists:

`public static boolean findUser(MongoCollection<Document> collection, String username)`

To check if password matches username: 

`public static boolean checkPassword(MongoCollection<Document> collection, String username, String password)`

To add a user upon registration: 

`public static void addUser(MongoCollection<Document> collection, String username, String password)`

To update # of wins and win percentage after a match: 

`public static void updateWins(MongoCollection<Document> collection, String username)`

To update # of losses and win percentage after a match:

`public static void updateLosses(MongoCollection<Document> collection, String username)`

To return a List of "Document" objects that contain the information for each user sorted by wins:

`public static List<Document> sortedWins(MongoCollection<Document> collection)`

Each Document object corresponds to one user. To access individual fields for a user, do 
`ListName.get(i).get(<field>)`

For example, to get the user with the most win's name, do
`ListName.get(0).get("username")`

The fields included are: username, password, wins, losses, percentage

To return a List of users sorted by win percentage:

`public static List<Document> sortedPercentage(MongoCollection<Document> collection)`

To return a single User document: 

`public static Document returnUser(MongoCollection<Document> collection, String username)`

`Document doc = returnUser(collection, username)`

`int wins = doc.get("wins")`

will give you the number of wins for the username searched. You can replace "wins" with "losses", "percentage", "username", "password" to get those respective fields.