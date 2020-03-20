import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        TravProfDB db = new TravProfDB("db.json");
        db.initializeDatabase();
        System.out.println(db);
        /*
        MedCond lauraMedCondInfo = new MedCond("Dr. Bob Smith", "806-435-9183",
                "medication", "diabetes");
        TravProf laura = new TravProf("TA1", "Lawrence", "Lucas", "12 Boston Tpke",
                "231-424-1938", 2351, "Pleasure", "Debit", lauraMedCondInfo);
        db.insertNewProfile(laura);
        db.writeAllTravProf();
        db.initializeDatabase();
        System.out.println(db);
        List<TravProf> res = db.getTravList("TA1");
        System.out.println(res);
        db.deleteProfile("TA1", "Doe");
        res = db.getTravList("TA1");
        System.out.println(res);
         */
    }

}