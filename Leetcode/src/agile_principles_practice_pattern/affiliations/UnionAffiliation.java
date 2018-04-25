package agile_principles_practice_pattern.affiliations;

import java.time.DayOfWeek;
import java.util.Date;

import agile_principles_practice_pattern.payroll_domain.Affiliation;

public class UnionAffiliation implements Affiliation {

    private final int memberId;
    private final double dues;

    public UnionAffiliation(int memberId, double dues) {
        this.memberId = memberId;
        this.dues = dues;
    }

    public void addServiceCharge(ServiceCharge serviceCharge) {

    }

    public int getMemberId() {
        return memberId;
    }

//    public double calculateDeductions(Paycheck paycheck) {
//        double totalDues = 0;
//
//        int fridays = NumberOfFridaysInPayPeriod(paycheck.PayPeriodStartDate, paycheck.PayPeriodEndDate);
//        totalDues = dues * fridays;
//        return totalDues;
//    }

//    private int NumberOfFridaysInPayPeriod(Date payPeriodStart, Date payPeriodEnd) {
//        int fridays = 0;
//        for (Date day = payPeriodStart; day <= payPeriodEnd; day.AddDays(1)) {
//            if (day.DayOfWeek == DayOfWeek.FRIDAY)
//                fridays++;
//        }
//        return fridays;
//    }
}
