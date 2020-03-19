import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TravProfDB {
    public final String PATH;
    private FileWriter writer;
    private BufferedReader reader;
    public List<TravProf> travelerList;
    private Gson gson;

    public TravProfDB(String path) throws IOException {
        this.PATH = path;
        this.travelerList = new LinkedList<>();
        this.gson = new Gson();
    }

    public void insertNewProfile(TravProf profile) { this.travelerList.add(profile); }

    public boolean deleteProfile(String travAgentId, String lastName) {
        int travProfileIndex = getTravProfileIndex(travAgentId, lastName);
        if (travProfileIndex >= 0) {
            this.travelerList.remove(travProfileIndex);
            return true;
        }
        return false;
    }

    public TravProf findProfile(String travAgentId, String lastName) {
        int travProfileIndex = getTravProfileIndex(travAgentId, lastName);
        return travProfileIndex == -1 ? null : this.travelerList.get(travProfileIndex);
    }

    private int getTravProfileIndex(String travAgentId, String lastName) {
        int i = 0;
        for (TravProf profile: this.travelerList) {
            if (profile.getTravAgentID().equals(travAgentId)
                    && profile.getLastName().equals(lastName))
                return i;
            ++i;
        }
        return -1;
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
