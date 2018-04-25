package agile_principles_practice_pattern.transaction;

import agile_principles_practice_pattern.payroll_domain.Affiliation;
import agile_principles_practice_pattern.payroll_domain.Employee;
import agile_principles_practice_pattern.affiliations.NoAffiliation;
import agile_principles_practice_pattern.payroll_database.PayrollDatabase;
import agile_principles_practice_pattern.affiliations.UnionAffiliation;

public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {

    public ChangeUnaffiliatedTransaction(int empId) {
        super(empId);
    }

    @Override
    protected Affiliation affiliation() {
        return new NoAffiliation();
    }

    @Override
    protected void recordMembership(Employee e) {
        Affiliation affiliation = e.getAffiliation();
        if(affiliation instanceof UnionAffiliation) {
            UnionAffiliation unionAffiliation = (UnionAffiliation) affiliation;
            int memberId = unionAffiliation.getMemberId();
            PayrollDatabase.removeUnionMember(memberId);
        }
    }
}
