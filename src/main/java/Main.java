import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TravProfInterface app = new TravProfInterface("db.json");
        app.run();
    }

}
