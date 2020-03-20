public class MedCond {
    private String mdContact;
    private String  mdPhone;
    private String algType;
    private String illType;

    public MedCond(String mdContact,String mdPhone, String algType, String illType){
        this.mdContact = mdContact;
        this.mdPhone = mdPhone;
        this.algType = algType;
        this.illType = illType;
    }

    public String getMdContact(){
        return this.mdContact;
    }

    public String getMdPhone(){
        return this.mdPhone;
    }

    public String getAlgType(){
        return this.algType;
    }

    public String getIllType(){
        return this.illType;
    }

    public void updateMdContact(String newMDC){
        this.mdContact = newMDC;
    }

    public void updateMdPhone(String newPhone){
        this.mdPhone = newPhone;
    }

    public void updateAlgType(String newAlgType){
        this.algType = newAlgType;
    }

    public void updateIllType(String newIllType){
        this.illType = newIllType;
    }

    public String toString() {
        return "Contact: " + this.mdContact + " (" + this.mdPhone + ")" +
                ", AlgType: " + this.algType + ", IllType: " + this.illType;
    }
}