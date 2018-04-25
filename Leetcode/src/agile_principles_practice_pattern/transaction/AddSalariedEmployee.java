package agile_principles_practice_pattern.transaction;

import agile_principles_practice_pattern.schedules.MonthlySchedule;
import agile_principles_practice_pattern.payroll_domain.PaymentClassification;
import agile_principles_practice_pattern.payroll_domain.PaymentSchedule;
import agile_principles_practice_pattern.classifications.SalariedClassification;

public class AddSalariedEmployee extends AddEmployeeTransaction {

    private final double salary;

    public AddSalariedEmployee(int empid, String name, String address, double salary) {
        super(empid, name, address);
        this.salary = salary;
    }

    @Override
    protected PaymentClassification makeClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    protected PaymentSchedule makeSchedule() {
        return new MonthlySchedule();
    }
}
