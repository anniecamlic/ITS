import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("started...");
        TravProfInterface app = new TravProfInterface("db.json");
        app.run();
    }

}
