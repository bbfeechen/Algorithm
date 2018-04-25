package agile_principles_practice_pattern.transaction;

import java.util.Date;

import agile_principles_practice_pattern.payroll_domain.Employee;
import agile_principles_practice_pattern.payroll_database.PayrollDatabase;
import agile_principles_practice_pattern.affiliations.ServiceCharge;
import agile_principles_practice_pattern.affiliations.UnionAffiliation;
import agile_principles_practice_pattern.payroll_domain.Transaction;

public class ServiceChargeTransaction implements Transaction {

    private final int memberId;
    private final Date time;
    private final double charge;

    public ServiceChargeTransaction(int memberId, Date time, double charge) {
        this.memberId = memberId;
        this.time = time;
        this.charge = charge;
    }

    @Override
    public void execute() {
//        Employee e = PayrollDatabase.getUnionMember(memberId);
//
//        if (e != null) {
//            UnionAffiliation ua = null;
//            if (e.getAffiliation() instanceof UnionAffiliation){
//                ua = (UnionAffiliation) e.getAffiliation();
//            }
//
//            if (ua != null) {
//                ua.addServiceCharge(new ServiceCharge(time, charge));
//            } else {
//                throw new IllegalStateException("Tries to add service charge to union "
//                        + "member without a union affiliation");
//            }
//        } else {
//            throw new IllegalStateException("No such union member.");
//        }
    }
}
