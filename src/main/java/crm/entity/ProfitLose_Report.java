package crm.entity;

import crm.dao.ProfitLoseDAO;

import java.time.LocalDate;

public class ProfitLose_Report {

    private double repairCost;
    private LocalDate repairStartDay;
    private LocalDate repairEndDay;

    // constructor

    public ProfitLose_Report(String repairStartDay, String repairEndDay) {
        setRepairStartDay(repairStartDay);
        setRepairEndDay(repairEndDay);
    }

    // get / set

    public double getRepairCost() {
        return repairCost;
    }

    public void setRepairCost() {
        this.repairCost = ProfitLoseDAO.chargeRepairFee(this);
    }

    public LocalDate getRepairStartDay() {
        return repairStartDay;
    }

    public void setRepairStartDay(String repairStartDay) {
        this.repairStartDay = LocalDate.parse(repairStartDay);
    }

    public LocalDate getRepairEndDay() {
        return repairEndDay;
    }

    public void setRepairEndDay(String repairEndDay) {
        this.repairEndDay = LocalDate.parse(repairEndDay);
    }
}
