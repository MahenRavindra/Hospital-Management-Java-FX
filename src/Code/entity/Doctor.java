package Code.entity;

// we create this class to represent the databse table of doctor
public class Doctor {
    private String id;
    private String name;
    private String address;
    private String contact;
    public Doctor() {
    }

    public Doctor(String did, String name, String address, String contact) {
        this.id = did;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }
    public String getDid() {
        return id;
    }

    public void setDid(String did) {
        this.id = did;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
