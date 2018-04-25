package agile_principles_practice_pattern.transaction;

import agile_principles_practice_pattern.payroll_domain.Employee;
import agile_principles_practice_pattern.methods.HoldMethod;
import agile_principles_practice_pattern.payroll_domain.PaymentClassification;
import agile_principles_practice_pattern.payroll_domain.PaymentMethod;
import agile_principles_practice_pattern.payroll_domain.PaymentSchedule;
import agile_principles_practice_pattern.payroll_database.PayrollDatabase;
import agile_principles_practice_pattern.payroll_domain.Transaction;

public abstract class AddEmployeeTransaction implements Transaction {

    private final int empid;
    private final String name;
    private final String address;

    public AddEmployeeTransaction(int empid, String name, String address) {
        this.empid = empid;
        this.name = name;
        this.address = address;
    }

    protected abstract PaymentClassification makeClassification();
    protected abstract PaymentSchedule makeSchedule();

    @Override
    public void execute() {
        PaymentClassification pc = makeClassification();
        PaymentSchedule ps = makeSchedule();
        PaymentMethod pm = new HoldMethod();

        Employee e = new Employee(empid, name, address);
        e.setClassification(pc);
        e.setSchedule(ps);
        e.setMethod(pm);
        PayrollDatabase.addEmployee(empid, e);
    }
}
