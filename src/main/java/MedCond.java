public class MedCond {
    private String mdContact;
    private String  mdPhone;
    private String algType;
    private String illType;

    /**
     * MedCond Constructor
     * Creates an instance of the MedCond Class
     *
     * @param mdContact - medical contact saved as  a string
     * @param mdPhone - medical contact's phone number saved as a string
     * @param algType - allergy type saved as a string
     * @param illType - illness type saved as a string
     *
     * @return instance of the MedCond class
     */
    public MedCond(String mdContact,String mdPhone, String algType, String illType){
        this.mdContact = mdContact;
        this.mdPhone = mdPhone;
        this.algType = algType;
        this.illType = illType;
    }

    /**
     * returns the MedCond object's medical contact
     */
    public String getMdContact(){
        return this.mdContact;
    }

    /**
     * returns the MedCond object's medical contact phone number
     */
    public String getMdPhone(){
        return this.mdPhone;
    }

    /**
     * returns the MedCond object's allergy type
     */
    public String getAlgType(){
        return this.algType;
    }

    /**
     * returns the MedCond object's illness type
     */
    public String getIllType(){
        return this.illType;
    }


    /**
     * updates the MedCond object's medical contact
     */
    public void updateMdContact(String newMDC){
        this.mdContact = newMDC;
    }

    /**
     * updates the MedCond object's medical contact phone number
     */
    public void updateMdPhone(String newPhone){
        this.mdPhone = newPhone;
    }

    /**
     * updates the MedCond object's allergy type
     */
    public void updateAlgType(String newAlgType){
        this.algType = newAlgType;
    }

    /**
     * updates the MedCond object's illness type
     */
    public void updateIllType(String newIllType){
        this.illType = newIllType;
    }


    /**
     * converts the MedCond object to a string
     *
     *
     * @return a MedCond instance in string form
     */
    public String toString() {
        return "Contact: " + this.mdContact + " (" + this.mdPhone + ")" +
                ", AlgType: " + this.algType + ", IllType: " + this.illType;
    }
}