package crm.entity;

import crm.dao.CarDAO;
import crm.dao.EmployeeDAO;

import java.time.LocalDate;

public class CarService {

    private int id;
    private LocalDate receiveDay;
    private LocalDate repairPlanDay;
    private LocalDate repair_start_day;
    private Employee employee;
    private String issueNote;
    private String repairNote;
    private RepairStatus repairStatus;
    private Car car;
    private double customerFee;
    private double partsFee;
    private double man_hours_cost;
    private int man_hours_amount;

    // toString

    @Override
    public String toString() {
        return "EmployeeService{" +
                "receiveDay=" + receiveDay +
                ", repairPlanDay=" + repairPlanDay +
                ", repair_start_day=" + repair_start_day +
                ", employee=" + employee +
                ", issueNote='" + issueNote + '\'' +
                ", repairNote='" + repairNote + '\'' +
                ", repairStatus=" + repairStatus +
                ", car=" + car +
                ", customerFee=" + customerFee +
                ", partsFee=" + partsFee +
                ", man_hours_cost=" + man_hours_cost +
                ", man_hours_amount=" + man_hours_amount +
                '}';
    }

    // constructors

    public CarService(String receiveDay, String repairPlanDay, String repair_start_day, int employeeId,
                      String issueNote, String repairNote, String repairStatus, int CarId, double customerFee,
                      double partsFee, double man_hours_cost, int man_hours_amount) {

        setReceiveDay(receiveDay);
        setRepairPlanDay(repairPlanDay);
        setRepair_start_day(repair_start_day);
        setEmployee(employeeId);
        this.issueNote = issueNote;
        this.repairNote = repairNote;
        setRepairStatus(repairStatus);
        setCar(CarId);
        this.customerFee = customerFee;
        this.partsFee = partsFee;
        setMan_hours_amount(man_hours_amount);
    }

    public CarService() {
    }

    // get / set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getReceiveDay() {
        return receiveDay;
    }

    public void setReceiveDay(String receiveDay) {
        this.receiveDay = LocalDate.parse(receiveDay);
    }

    public LocalDate getRepairPlanDay() {
        return repairPlanDay;
    }

    public void setRepairPlanDay(String repairPlanDay) {
        this.repairPlanDay = LocalDate.parse(repairPlanDay);
    }

    public LocalDate getRepair_start_day() {
        return repair_start_day;
    }

    public void setRepair_start_day(String repair_start_day) {
        this.repair_start_day = LocalDate.parse(repair_start_day);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(int employeeId) {
        this.employee = EmployeeDAO.getEmployeeById(employeeId);
        if(man_hours_amount != 0){
            setMan_hours_cost(man_hours_amount * employee.getMan_hours_cost());
        }
    }

    public String getIssueNote() {
        return issueNote;
    }

    public void setIssueNote(String issueNote) {
        this.issueNote = issueNote;
    }

    public String getRepairNote() {
        return repairNote;
    }

    public void setRepairNote(String repairNote) {
        this.repairNote = repairNote;
    }

    public RepairStatus getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(String repairStatus) {
        this.repairStatus = RepairStatus.valueOf(repairStatus);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(int CarId) {
        this.car = CarDAO.getById(CarId);
    }

    public double getCustomerFee() {
        return customerFee;
    }

    public void setCustomerFee(double customerFee) {
        this.customerFee = customerFee;
    }

    public double getPartsFee() {
        return partsFee;
    }

    public void setPartsFee(double partsFee) {
        this.partsFee = partsFee;
    }

    public double getMan_hours_cost() {
        return man_hours_cost;
    }

    public void setMan_hours_cost(double man_hours_cost) {
        this.man_hours_cost = man_hours_cost;
    }

    public int getMan_hours_amount() {
        return man_hours_amount;
    }

    public void setMan_hours_amount(int man_hours_amount) {
        this.man_hours_amount = man_hours_amount;
        if(employee != null){
            setMan_hours_cost(man_hours_cost * employee.getMan_hours_cost());
        }
    }
}
