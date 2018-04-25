package agile_principles_practice_pattern.transaction;

import agile_principles_practice_pattern.payroll_database.PayrollDatabase;
import agile_principles_practice_pattern.payroll_domain.Transaction;

public class DeleteEmployeeTransaction implements Transaction {
    private final int id;

    public DeleteEmployeeTransaction(int id) {
        this.id = id;
    }

    @Override
    public void execute() {
        PayrollDatabase.deleteEmployee(id);
    }
}
