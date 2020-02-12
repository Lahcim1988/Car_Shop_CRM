package crm.entity;

import java.time.LocalDate;

public class Customer {

    private int id;
    private String name;
    private String surName;
    private LocalDate dateOfBirth;

    // toString

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }

    // constructors

    public Customer(String name, String surName, String dateOfBirth) {
        this.name = name;
        this.surName = surName;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
    }

    public Customer() {
    }

    public Customer(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

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

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
    }
}
