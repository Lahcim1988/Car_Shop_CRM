package crm.entity;

import crm.dao.ManHoursDAO;

import java.time.LocalDate;
import java.util.List;

public class ManHours_Report {

    private List<String[]> hoursList;
    private LocalDate repair_start_time;
    private LocalDate repair_end_time;

    // Constructors

    public ManHours_Report(String repair_start_time, String repair_end_time) {
        setRepair_start_time(repair_start_time);
        setRepair_end_time(repair_end_time);
    }

    public ManHours_Report() {}

    // get / set


    public List<String[]> getHoursList() {
        return hoursList;
    }

    public void setHoursList() {
        this.hoursList = ManHoursDAO.getHoursRaport(this);
    }

    public LocalDate getRepair_start_time() {
        return repair_start_time;
    }

    public void setRepair_start_time(String repair_start_time) {
        this.repair_start_time = LocalDate.parse(repair_start_time);
    }

    public LocalDate getRepair_end_time() {
        return repair_end_time;
    }

    public void setRepair_end_time(String repair_end_time) {
        this.repair_end_time = LocalDate.parse(repair_end_time);
    }
}
