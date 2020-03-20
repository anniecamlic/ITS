import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TravProfDB db = new TravProfDB("db.json");
        db.initializeDatabase();
        System.out.println(db);
    }

}
