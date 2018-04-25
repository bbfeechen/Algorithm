package agile_principles_practice_pattern.transaction;

import agile_principles_practice_pattern.payroll_domain.Affiliation;
import agile_principles_practice_pattern.payroll_domain.Employee;
import agile_principles_practice_pattern.payroll_database.PayrollDatabase;
import agile_principles_practice_pattern.affiliations.UnionAffiliation;

public class ChangeMemberTransaction extends ChangeAffiliationTransaction {

    private final int memberId;
    private final double dues;

    public ChangeMemberTransaction(int empId, int memberId, double dues) {
        super(empId);
        this.memberId = memberId;
        this.dues = dues;
    }

    @Override
    protected Affiliation affiliation() {
        return new UnionAffiliation(memberId, dues);
    }

    @Override
    protected void recordMembership(Employee e) {
        PayrollDatabase.addUnionMember(memberId, e);
    }
}
