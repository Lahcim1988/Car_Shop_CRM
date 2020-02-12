package crm.entity;

public class Car {

    private int id;
    private int customer_id;
    private String model;
    private String brand;
    private String yearOfManufacture;
    private String registrationNumber;
    private String nextService;

    // toString

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", yearOfManufacture='" + yearOfManufacture + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", nextService='" + nextService + '\'' +
                '}';
    }

    // constructors

    public Car(String model, String brand, String yearOfManufacture, String registrationNumber, String nextService) {
        this.model = model;
        this.brand = brand;
        this.yearOfManufacture = yearOfManufacture;
        this.registrationNumber = registrationNumber;
        this.nextService = nextService;
    }

    public Car() {}

    public Car(int customer_id, String model, String brand, String yearOfManufacture, String registrationNumber, String nextService) {
        this.customer_id = customer_id;
        this.model = model;
        this.brand = brand;
        this.yearOfManufacture = yearOfManufacture;
        this.registrationNumber = registrationNumber;
        this.nextService = nextService;
    }

    // get / set


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getNextService() {
        return nextService;
    }

    public void setNextService(String nextService) {
        this.nextService = nextService;
    }
}
