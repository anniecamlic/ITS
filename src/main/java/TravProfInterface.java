import java.io.IOException;
import java.util.List;

public class TravProfInterface {
    private final String PATH;
    private TravProfDB db;

    TravProfInterface (String path) throws IOException {
        System.out.println("created interface instance!");
        this.PATH = path;
        this.db = new TravProfDB(path);
    }

    public void run() throws IOException {
        System.out.println("running...");
        this.initDB();
        this.getUserChoice();
    }

    private void getUserChoice() throws IOException {
        /*
            TODO: read input from user using Scanner class
            TODO: make sure to call this.db.writeAllTravProf() to save application state after user exits

            Example menu we could have:

            Actions:
            0 - find traveler profile
            1 - update traveler profile
            . - ...
            3 - quit application
         */
        int input = 1;
        boolean isDone = false;

        while (!isDone) {
            // TODO: print menu
            switch(input) {
                case 1:
                    this.updateTravProf();
                    break;
                case 2:
                    isDone = true;
                    break;
                case 3:
                    System.out.println("Bye!");
                    this.writeToDB(this.PATH);
                default:
                    System.out.println("Invalid input. Try again...");
            }
        }
    }

    private void writeToDB(String path) throws IOException { this.db.writeAllTravProf(path); }

    private void findTravProf() {
        /*
            TODO: get travAgentId and lastName
            call this.db.findProfile(travAgentId,lastName) to get the TravProf
            call this.displayTravProf(TravProf)
         */
    }

    private void displayTravProf(TravProf profile) { System.out.println(profile); }

    private void displayAllTravProf(String travAgentId) {
        List<TravProf> profiles = this.db.getTravList(travAgentId);
        // TODO: use a for each loop to go through every TravProf in "profiles" variable and call displayTravProf
    }

    private void updateTravProf() {
        // TODO: get travAgentId and lastName
        // call this.db.findProfile(travAgentId,lastName) to get the TravProf
        // print a list of attributes that user is allowed to modify (use switch case)
        /*
        Select modifiable attributes:
        0 - first name
        1 - last name
        2 - medical condition info
         */
        int input = 0;
        switch (input) {
            case 0:
                // serve action 0
                break;
            case 1:
                // serve action 1
                break;
            case 2:
                // serve action 2
                this.updateMedCond();
                break;
            default:
                break;
        }
    }

    private void updateMedCond() {
        // same idea as updateTravProf
    }

    public void initDB() throws IOException { this.db.initializeDatabase(); }

    private void createNewTravProf() {
        /*
        TODO
         1. use Scanner class to prompt and read user data required to create a TravProf
         (this includes required info to create a MedCond instance)
         2. Create a MedCond instance
         3. Create a TravProf instance (e.g., profile)
         4. Insert into db using this.db.insertNewProfile(profile)
         5. Inform the user of the status (e.g., "profile created!")
         */
    }

    private void createNewMedCond() { } // To be called by createNewTravProf
}