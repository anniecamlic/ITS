import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<TravProf> getTravList(String travAgentId) {
        return this.travelerList.stream() // converting the list to stream
                                .filter(travProf -> travProf.getTravAgentID().equals(travAgentId)) // filter the stream to create a new stream
                                .collect(Collectors.toList()); // collect the final stream and convert it to a List
    }

    public void writeAllTravProf() throws IOException { this.writeAllTravProf(this.PATH); }

    public void writeAllTravProf(String path) throws IOException {
        String json = this.gson.toJson(this.travelerList);
        File file = new File(path);
        FileWriter writer = new FileWriter(file, false);
        writer.write(json);
        writer.flush();
        writer.close();
    }

    public void initializeDatabase() throws IOException { this.initializeDatabase(this.PATH); }

    public void initializeDatabase(String path) throws IOException {
        String json = Files.readString(Paths.get(path));
        Type collectionType = new TypeToken<Collection<TravProf>>(){}.getType();
        this.travelerList = gson.fromJson(json, collectionType);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (TravProf profile: this.travelerList) {
            str.append(profile.toString()).append("\n");
        }
        return str.toString();
    }
}
