package agile_principles_practice_pattern.transaction;

import agile_principles_practice_pattern.payroll_domain.Affiliation;
import agile_principles_practice_pattern.payroll_domain.Employee;

public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {

    public ChangeAffiliationTransaction(int empId) {
        super(empId);
    }

    @Override
    protected void Change(Employee e) {
        recordMembership(e);
        e.setAffiliation(affiliation());
    }

    protected abstract Affiliation affiliation();
    protected abstract void recordMembership(Employee e);
}
