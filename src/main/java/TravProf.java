public class TravProf {
    private static MedCond medCondInfo;
    private String travelAgentID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private double tripCost;
    private String travelType;
    private String paymentType;

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
    public String getTravAgentID(){
        return this.travelAgentID;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getAddress(){
        return this.address;
    }
    public String getPhone(){
        return this.phone;
    }
    public double getTripCost(){
        return this.tripCost;
    }
    public String getTravelType(){
        return this.travelType;
    }
    public String getPaymentType(){
        return this.paymentType;
    }
    public MedCond getMedCondInfo(){
        return this.medCondInfo;
    }
    public void updateFirstName(String newName){
        this.firstName = newName;
    }
    public void updateLastName(String newName){
        this.lastName = newName;
    }
    public void updateAddress(String newAddress){
        this.address = newAddress;
    }
    public void updatePhone(String newPhone){
        this.phone = newPhone;
    }
    public void updateTripCost(Float newCost){
        this.tripCost = newCost;
    }
    public void updateTravelType(String newTType){
        this.travelType = newTType;
    }
    public void updatePaymentType(String newPType){
        this.paymentType = newPType;
    }
    public void updateMedCondInfo(MedCond newMC){
        this.medCondInfo = newMC;
    }
    public String toString() { return this.firstName + " " + this.lastName; }
}
