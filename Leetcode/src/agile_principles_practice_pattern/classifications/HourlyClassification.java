package agile_principles_practice_pattern.classifications;

import java.util.Date;

import agile_principles_practice_pattern.TimeCard;
import agile_principles_practice_pattern.payroll_domain.PaymentClassification;

public class HourlyClassification implements PaymentClassification {
    private final double hourlyRate;

    public HourlyClassification(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void addTimeCard(TimeCard timeCard) {

    }

//    public double CalculatePay(Paycheck paycheck) {
//        double totalPay = 0.0;
//        for (TimeCard timeCard : timeCards.Values)
//        {
//            if(IsInPayPeriod(timeCard, paycheck.PayDate))
//                totalPay += CalculatePayForTimeCard(timeCard);
//        }
//        return totalPay;
//    }
//
//    private boolean IsInPayPeriod(TimeCard card, Date payPeriod) {
//        Date payPeriodEndDate = payPeriod;
//        Date payPeriodStartDate = payPeriod.AddDays(-5);
//
//        return card.Date <= payPeriodEndDate &&
//                card.Date >= payPeriodStartDate;
//    }
//
//    private double CalculatePayForTimeCard(TimeCard card) {
//        double overtimeHours = Math.max(0.0, card.Hours - 8);
//        double normalHours = card.Hours - overtimeHours;
//        return hourlyRate * normalHours +
//                hourlyRate * 1.5 * overtimeHours;
//    }
}
