package agile_principles_practice_pattern.transaction;

import java.util.Date;

import agile_principles_practice_pattern.payroll_domain.Employee;
import agile_principles_practice_pattern.payroll_database.PayrollDatabase;
import agile_principles_practice_pattern.TimeCard;
import agile_principles_practice_pattern.classifications.HourlyClassification;
import agile_principles_practice_pattern.payroll_domain.Transaction;

public class TimeCardTransaction implements Transaction {
    private final Date date;
    private final double hours;
    private final int empId;

    public TimeCardTransaction(Date date, double hours, int empId) {
        this.date = date;
        this.hours = hours;
        this.empId = empId;
    }

    @Override
    public void execute() {
        Employee e = PayrollDatabase.getEmployee(empId);

        if (e != null) {
            HourlyClassification hc = (HourlyClassification) e.getClassification();
            if (hc != null) {
                hc.addTimeCard(new TimeCard(date, hours));
            } else {
                throw new IllegalStateException("Tried to add timecard to non-hourly employee");
            }
        } else {
            throw new IllegalStateException("No such employee.");
        }
    }
}
