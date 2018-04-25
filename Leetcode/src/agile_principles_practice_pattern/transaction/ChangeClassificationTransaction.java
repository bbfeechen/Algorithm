package agile_principles_practice_pattern.transaction;

import agile_principles_practice_pattern.payroll_domain.Employee;
import agile_principles_practice_pattern.payroll_domain.PaymentClassification;
import agile_principles_practice_pattern.payroll_domain.PaymentSchedule;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {

    public ChangeClassificationTransaction(int empId) {
        super(empId);
    }

    @Override
    protected void Change(Employee e) {
        e.setClassification(classification());
        e.setSchedule(schedule());
    }

    protected abstract PaymentClassification classification();
    protected abstract PaymentSchedule schedule();
}
