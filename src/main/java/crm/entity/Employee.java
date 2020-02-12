package crm.entity;

public class Employee {

    private int id;
    private String name;
    private String surName;
    private String address;
    private String mobilePhone;
    private String note;
    private double man_hours_cost;

    // toString

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", address='" + address + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", note='" + note + '\'' +
                ", man_hours_cost=" + man_hours_cost +
                '}';
    }

    // constructors

    public Employee(String name, String surName, String address, String mobilePhone, String note, double man_hours_cost) {
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.mobilePhone = mobilePhone;
        this.note = note;
        this.man_hours_cost = man_hours_cost;
    }
    public Employee() {}

    // get / set


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String sureName) {
        this.surName = sureName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getMan_hours_cost() {
        return man_hours_cost;
    }

    public void setMan_hours_cost(double man_hours_cost) {
        this.man_hours_cost = man_hours_cost;
    }
}
