public class TravProf {
    private MedCond medCondInfo;
    private String travelAgentID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private double tripCost;
    private String travelType;
    private String paymentType;

    /**
     * TravProf Constructor
     * Creates an instance of the TravProf Class
     *
     * @param travelAgentID - travel agent ID saved as a string
     * @param firstName - first name saved as a string
     * @param lastName - last name saved as a string
     * @param address - phone number saved as a string
     * @param tripCost - cost of trip saved as a doubly
     * @param travelType - travel type saved as a string
     * @param paymentType - payment type saved as a string
     * @param medCondInfo - medical condition information saved as an instance of the MedCond class
     *
     * @return instance of the TravProf class
     */
    public TravProf(String travelAgentID, String firstName, String lastName, String address,
                    String phone, double tripCost, String travelType, String paymentType, MedCond medCondInfo){
        this.travelAgentID = travelAgentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.tripCost = tripCost;
        this.travelType = travelType;
        this.paymentType = paymentType;
        this.medCondInfo = medCondInfo;
    }

    /**
     * returns the TravProf object's travel agent ID
     */
    public String getTravAgentID(){ return this.travelAgentID; }

    /**
     * returns the TravProf object's first name
     */
    public String getFirstName(){ return this.firstName; }

    /**
     * returns the TravProf object's last name
     */
    public String getLastName(){ return this.lastName; }

    /**
     * returns the TravProf object's address
     */
    public String getAddress(){ return this.address; }

    /**
     * returns the TravProf object's phone number
     */
    public String getPhone(){ return this.phone; }

    /**
     * returns the TravProf object's trip cost
     */
    public double getTripCost(){ return this.tripCost; }

    /**
     * returns the TravProf object's travel type
     */
    public String getTravelType(){ return this.travelType; }

    /**
     * returns the TravProf object's payment type
     */
    public String getPaymentType(){ return this.paymentType; }

    /**
     * returns the TravProf object's medical condition information
     */
    public MedCond getMedCondInfo(){ return this.medCondInfo; }

    /**
     * updates the TravProf object's first name
     */
    public void updateFirstName(String newName){ this.firstName = newName; }

    /**
     * updates the TravProf object's last name
     */
    public void updateLastName(String newName){ this.lastName = newName; }

    /**
     * updates the TravProf object's address
     */
    public void updateAddress(String newAddress){ this.address = newAddress; }

    /**
     * updates the TravProf object's phone number
     */
    public void updatePhone(String newPhone){ this.phone = newPhone; }

    /**
     * updates the TravProf object's trip cose
     */
    public void updateTripCost(double newCost){ this.tripCost = newCost; }

    /**
     * updates the TravProf object's travel type
     */
    public void updateTravelType(String newTType){ this.travelType = newTType; }

    /**
     * updates the TravProf object's payment type
     */
    public void updatePaymentType(String newPType){ this.paymentType = newPType; }

    /**
     * updates the TravProf object's medical condition information
     */
    public void updateMedCondInfo(MedCond newMC){ this.medCondInfo = newMC; }

    /**
     * converts the TravProf object to a string
     *
     * @return a TravProf instance in string form
     */
    public String toString() {
        return this.firstName + " " + this.lastName +
                (this.medCondInfo != null ? " [" + this.medCondInfo.toString() + "]" : "");
    }

    /**
     * compares two objects to see if they are equivalent
     *
     * @param o - this is an object being compared
     * @return a boolean value that described whether or not two objects are equal
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TravProf)) return false;
        TravProf profile = (TravProf) o;
        return this.travelAgentID.equals(profile.travelAgentID)
                && this.lastName.equals(profile.lastName);
    }
}
