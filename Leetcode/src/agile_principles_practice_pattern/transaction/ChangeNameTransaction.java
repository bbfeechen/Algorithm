package agile_principles_practice_pattern.transaction;

import agile_principles_practice_pattern.payroll_domain.Employee;

public class ChangeNameTransaction extends ChangeEmployeeTransaction {

    private final String newName;

    public ChangeNameTransaction(int empId, String newName) {
        super(empId);
        this.newName = newName;
    }

    @Override
    protected void Change(Employee e) {
        e.setName(newName);
    }
}
