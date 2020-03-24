import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TravProfInterface {
    private final String PATH;
    private TravProfDB db;
    private Scanner scanner;

    TravProfInterface (String PATH) throws IOException {
        this.PATH = PATH;
        this.db = new TravProfDB(PATH);
        this.scanner = new Scanner(System.in);
    }

    public void run() throws IOException {
        initDB();
        getUserChoice();
    }

    private void printMenu() {
        final String MENU_TITLE = "========ACTIONS-MENU========";
        final List<String> MENU = List.of(
                "1 - create new traveler profile",
                "2 - delete traveler profile",
                "3 - update traveler profile",
                "4 - display traveler profile",
                "5 - display all traveler profiles",
                "6 - write to database",
                "7 - close app"
        );

        System.out.println(MENU_TITLE);
        for (String item: MENU)
            System.out.println(item);
        System.out.println("============================");
    }

    private void getUserChoice() throws IOException {
        int input;
        boolean isDone = false;

        while (!isDone) {
            printMenu();
            input = Integer.parseInt(scanner.nextLine());

            switch(input) {
                case 1:
                    createNewTravProf();
                    break;
                case 2:
                    deleteTravProf();
                    break;
                case 3:
                    updateTravProf();
                    break;
                case 4:
                    findTravProf();
                    break;
                case 5:
                    displayAllTravProf(getUserInput("Please enter travel agent ID:"));
                    break;
                case 6:
                    writeToDB(PATH);
                    break;
                case 7:
                    isDone = true;
                    System.out.println("Bye!");
                    writeToDB(PATH);
                    break;
                default:
                    System.out.println("Invalid input: \"" + input + "\". Try again...");
            }
        }
    }

    private void deleteTravProf() {
        String[] profileIdentifiers = getProfileIdentifiers();
        String travAgentId = profileIdentifiers[0];
        String lastName = profileIdentifiers[1];

        boolean success = db.deleteProfile(travAgentId, lastName);

        if (success) {
            System.out.println("Profile with agent id " + travAgentId +
                    " and last name " + lastName + " deleted!");
        } else {
            System.out.println("Profile with agent id " + travAgentId +
                    " and last name " + lastName + " does not exist!");
        }
    }

    private void writeToDB(String path) throws IOException { this.db.writeAllTravProf(path); }

    private void findTravProf() {
        String[] profileIdentifiers = getProfileIdentifiers();
        String travAgentId = profileIdentifiers[0];
        String lastName = profileIdentifiers[1];
        TravProf profile = db.findProfile(travAgentId,lastName);
        displayTravProf(profile);
    }

    private void displayTravProf(TravProf profile) {
        if (profile != null) {
            System.out.println(profile);
        } else {
            System.out.println("Profile does not exist :(");
        }
    }

    private void displayAllTravProf(String travAgentId) {
        List<TravProf> profiles = db.getTravList(travAgentId);
        if (profiles.size() > 0) {
            for (TravProf profile: db.getTravList(travAgentId))
                displayTravProf(profile);
        } else {
            System.out.println("There are no traveler profiles associates with " +
                    travAgentId + " in the database!");
        }
    }

    private String[] getProfileIdentifiers() {
        String travAgentId = getUserInput("Enter Travel Agent ID:");
        String lastName = getUserInput("Enter last name:");
        return new String[]{travAgentId, lastName};
    }

    // TODO
    private void getTravelType() { }

    // TODO
    private void getAllergyType() { }

    // TODO
    private void getIllnessType() { }

    private void updateTravProf() {
        String[] profileIdentifiers = getProfileIdentifiers();
        String travAgentId = profileIdentifiers[0];
        String lastName = profileIdentifiers[1];

        TravProf profile = db.findProfile(travAgentId,lastName);

        if (profile == null) {
            System.out.println("Traveler profile does not exist!");
            return;
        }

        System.out.println("Select Modifiable Attributes:");
        System.out.println("1 - first name");
        System.out.println("2 - last name");
        System.out.println("3 - address");
        System.out.println("4 - phone");
        System.out.println("5 - trip cost");
        System.out.println("6 - travel type");
        System.out.println("7 - payment type");
        System.out.println("8 - medical condition information");

        int input = Integer.parseInt(scanner.nextLine());

        switch (input) {
            case 1:
                profile.updateFirstName(getUserInput("Enter new first name:"));
                break;
            case 2:
                profile.updateLastName(getUserInput("Enter new last name:"));
                break;
            case 3:
                System.out.println("new address:");
                String address = scanner.nextLine();
                profile.updateAddress(address);
                break;
            case 4:
                profile.updatePhone(getUserInput("Enter new phone:"));
                break;
            case 5:
                profile.updateTripCost(Double.parseDouble(getUserInput("Enter new trip cost:")));
                break;
            case 6:
                profile.updateTravelType(getUserInput("Enter new travel type:"));
                break;
            case 7:
                profile.updatePaymentType(getUserInput("Enter new payment type:"));
                break;
            case 8:
                this.updateMedCond();
                break;
        }
    }

    private void updateMedCond() {
        String[] profileIdentifiers = getProfileIdentifiers();
        String travAgentId = profileIdentifiers[0];
        String lastName = profileIdentifiers[1];

        TravProf profile = db.findProfile(travAgentId,lastName);
        MedCond mc = profile.getMedCondInfo();

        System.out.println("Select Modifiable Attributes: ");
        System.out.println("1 - medical contact");
        System.out.println("2 - medical contact phone");
        System.out.println("3 - allergy type");
        System.out.println("4 - illness type");

        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
                mc.updateMdContact(getUserInput("enter new medical contact:"));
                break;
            case 2:
                System.out.println("enter new medical contact phone: ");
                String newMedConPhone = scanner.nextLine();
                mc.updateMdPhone(newMedConPhone);
                break;
            case 3:
                System.out.println("enter new allergy type: ");
                String newAlgType = scanner.nextLine();
                mc.updateAlgType(newAlgType);
                break;
            case 4:
                System.out.println("enter new illness type: ");
                String newIllnessType = scanner.nextLine();
                mc.updateIllType(newIllnessType);
                break;
        }

    }

    public void initDB() throws IOException { this.db.initializeDatabase(); }

    private String getUserInput(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    private void createNewTravProf() {
        String travAgentId = getUserInput("Enter Travel Agent ID:");
        String firstName = getUserInput("Enter First Name:");
        String lastName = getUserInput("Enter Last Name:");
        String phone = getUserInput("Enter Phone Number:");
        double tripCost = Double.parseDouble(getUserInput("Enter Trip Cost:"));
        String travelType = getUserInput("Enter Travel Type:");
        String paymentType = getUserInput("Enter Payment Type:");
        // TODO fix
        System.out.println("Enter address:");
        String address = scanner.nextLine();

        MedCond mc = createNewMedCond();

        TravProf profile = new TravProf(travAgentId,firstName,lastName,address.toString(),phone,tripCost,travelType,paymentType,mc);
        db.insertNewProfile(profile);

        System.out.println("Profile created for: " + firstName + " " + lastName);
    }

    private MedCond createNewMedCond() {
        String medicalContact = getUserInput("Enter Medical Contact:");
        String medicalContactPhone = getUserInput("Enter Medical Contact Phone Number:");
        String allergyType = getUserInput("Enter Allergy Type:");
        String illnessType = getUserInput("Enter Illness Type:");
        return new MedCond(medicalContact,medicalContactPhone,allergyType,illnessType);
    }
}