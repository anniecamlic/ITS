import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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

            //TODO: Check that I did this correctly. I am unsure of what to call for "delete traveler profile



        Scanner scanner = new Scanner(System.in);
        System.out.println("Actions: ");
        System.out.println("1 - create new traveler profile");
        System.out.println("2 - delete traveler profile");
        System.out.println("3 - update traveler profile");
        System.out.println("4 - display traveler profile");
        System.out.println("5 - display all traveler profiles");
        System.out.println("6 - write to DB");
        System.out.println("7 - close app");

        int input = Integer.parseInt(scanner.next());
        boolean isDone = false;

        while (!isDone) {
            // TODO: print menu
            switch(input) {
                case 1:
                    createNewTravProf();
                    break;
                case 2:
                    //TODO
                    // I don't know how to do this
                    break;
                case 3:
                    updateTravProf();
                case 4:
                    findTravProf();
                case 5:
                    //to call this we need the user input
                    System.out.println("please enter travel agent ID");
                    String travAgentID = scanner.next();
                    displayAllTravProf(travAgentID);
                case 6:
                    writeToDB(PATH);
                case 7:
                    //is this correct?
                    isDone = true;
                    System.out.println("Bye!");
                    this.writeToDB(this.PATH);
                    break;
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
            DONE
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Travel Agent ID: ");
        String travAgentId = scanner.nextLine();
        System.out.println();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println();

        TravProf profile = this.db.findProfile(travAgentId,lastName);
        this.displayTravProf(profile);
    }

    private void displayTravProf(TravProf profile) { System.out.println(profile); }

    private void displayAllTravProf(String travAgentId) {
        List<TravProf> profiles = this.db.getTravList(travAgentId);
        // TODO: is this correctly implemented?
        for (int i = 0; i < profiles.size(); i++) {
            this.displayTravProf(profiles.get(i));
        }
    }

    private void updateTravProf() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Travel Agent ID: ");
        String travAgentId = scanner.nextLine();
        System.out.println();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println();

        TravProf profile = this.db.findProfile(travAgentId,lastName);

        System.out.println("Select Modifiable Attributes: ");
        System.out.println("1 - first name");
        System.out.println("2 - last name");
        System.out.println("3 - address");
        System.out.println("4 - phone");
        System.out.println("5 - trip cost");
        System.out.println("6 - travel type");
        System.out.println("7 - payment type");
        System.out.println("8 - medical condition information");

        int input = Integer.parseInt(scanner.next());

        switch (input) {
            case 1:
                System.out.println("enter new first name: ");
                String newFirst = scanner.nextLine();
                profile.updateFirstName(newFirst);
                break;
            case 2:
                System.out.println("enter new last name: ");
                String newLast = scanner.nextLine();
                profile.updateLastName(newLast);
                break;
            case 3:
                System.out.println("enter new address: ");
                String newAddress = scanner.nextLine();
                profile.updateAddress(newAddress);
                break;
            case 4:
                System.out.println("enter new phone number: ");
                String newPhone = scanner.nextLine();
                profile.updatePhone(newPhone);
                break;
            case 5:
                System.out.println("enter new trip cost: ");
                Float newTripCost = Float.parseFloat(scanner.nextLine());
                profile.updateTripCost(newTripCost);
                break;
            case 6:
                System.out.println("enter new travel type: ");
                String newTravelType = scanner.nextLine();
                profile.updateTravelType(newTravelType);
                break;
            case 7:
                System.out.println("enter new payment type: ");
                String newPaymentType = scanner.nextLine();
                profile.updatePaymentType(newPaymentType);
                break;
            case 8:
                this.updateMedCond();
                break;
            default:
                break;
        }
    }

    private void updateMedCond() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Travel Agent ID: ");
        String travAgentId = scanner.nextLine();
        System.out.println();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println();

        TravProf profile = this.db.findProfile(travAgentId,lastName);
        MedCond mc = profile.getMedCondInfo();

        System.out.println("Select Modifiable Attributes: ");
        System.out.println("1 - medical contact");
        System.out.println("2 - medical contact phone");
        System.out.println("3 - allergy type");
        System.out.println("4 - illness type");

        int input = Integer.parseInt(scanner.next());
        switch (input) {
            case 1:
                System.out.println("enter new medical contact: ");
                String newMedCon = scanner.nextLine();
                mc.updateMdContact(newMedCon);
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
            default:
                break;
        }

    }

    public void initDB() throws IOException { this.db.initializeDatabase(); }

    private void createNewTravProf() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Travel Agent ID: ");
        String travAgentId = scanner.nextLine();
        System.out.println();

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.println();

        System.out.print("Enter Last Name ");
        String lastName = scanner.nextLine();
        System.out.println();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.println();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();
        System.out.println();

        System.out.print("Enter Trip Cost: ");
        Double tripCost = Double.parseDouble(scanner.nextLine());
        System.out.println();

        System.out.print("Enter Travel Type: ");
        String travelType = scanner.nextLine();
        System.out.println();

        System.out.print("Enter Payment Type: ");
        String paymentType = scanner.nextLine();
        System.out.println();

        MedCond mc = createNewMedCond();

        TravProf profile = new TravProf(travAgentId,firstName,lastName,address,phone,tripCost,travelType,paymentType,mc);
        this.db.insertNewProfile(profile);
        System.out.println("Profile Created!");

    }

    private MedCond createNewMedCond() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Medical Contact: ");
        String medicalContact = scanner.nextLine();
        System.out.println();

        System.out.print("Enter Medical Contact Phone Number: ");
        String medicalContactPhone = scanner.nextLine();
        System.out.println();

        System.out.print("Enter Allergy Type: ");
        String allergyType = scanner.nextLine();
        System.out.println();

        System.out.print("Enter Illness Type: ");
        String illnessType = scanner.nextLine();
        System.out.println();

        return new MedCond(medicalContact,medicalContactPhone,allergyType,illnessType);

    }
}