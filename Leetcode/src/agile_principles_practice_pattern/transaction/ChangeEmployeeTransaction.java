package agile_principles_practice_pattern.transaction;

import agile_principles_practice_pattern.payroll_domain.Employee;
import agile_principles_practice_pattern.payroll_database.PayrollDatabase;
import agile_principles_practice_pattern.payroll_domain.Transaction;

public abstract class ChangeEmployeeTransaction implements Transaction {
    private final int empId;

    public ChangeEmployeeTransaction(int empId) {
        this.empId = empId;
    }

    @Override
    public void execute() {
        Employee e = PayrollDatabase.getEmployee(empId);

        if(e != null) {
            Change(e);
        } else {
            throw new IllegalStateException("No such employee.");
        }
    }

    protected abstract void Change(Employee e);
}
