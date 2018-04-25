package agile_principles_practice_pattern.transaction;

import agile_principles_practice_pattern.classifications.HourlyClassification;
import agile_principles_practice_pattern.payroll_domain.PaymentClassification;
import agile_principles_practice_pattern.payroll_domain.PaymentSchedule;
import agile_principles_practice_pattern.schedules.WeeklySchedule;

public class ChangeHourlyTransaction extends ChangeClassificationTransaction {
    private final double hourlyRate;

    public ChangeHourlyTransaction(int empId, double hourlyRate) {
        super(empId);
        this.hourlyRate = hourlyRate;
    }

    @Override
    protected PaymentClassification classification() {
        return new HourlyClassification(hourlyRate);
    }

    @Override
    protected PaymentSchedule schedule() {
        return new WeeklySchedule();
    }
}
