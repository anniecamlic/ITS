import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TravProfDB {
    public final String PATH;
    private int currentTravelerIndex;
    private FileWriter writer;
    private BufferedReader reader;
    public List<TravProf> travelerList;
    private Gson gson;

    public TravProfDB(String path) throws IOException {
        this.PATH = path;
        this.travelerList = new ArrayList<>();
        this.gson = new Gson();
        /*
        this.travelerList = Arrays.asList(
                new TravProf("1", "John", "Doe", "20 Post Rd",
                        "203-345-2341", 456, "Pleasure", "Credit", null),
                new TravProf("2", "Bob", "Smith", "25 Flat Rock",
                        "203-345-2321", 1023, "Pleasure", "Debit", null)
        );
        */
    }

    public void writeAllTravProf(String path) throws IOException {
        String json = this.gson.toJson(this.travelerList);
        File file = new File(this.PATH);
        FileWriter writer = new FileWriter(file, false);
        writer.write(json);
        writer.flush();
        writer.close();
    }

    public void initializeDatabase(String path) throws IOException {
        String json = Files.readString(Paths.get(path));
        Type collectionType = new TypeToken<Collection<TravProf>>(){}.getType();
        this.travelerList = gson.fromJson(json, collectionType);
    }
}
