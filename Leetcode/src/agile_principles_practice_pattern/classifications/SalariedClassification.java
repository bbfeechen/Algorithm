package agile_principles_practice_pattern.classifications;

import agile_principles_practice_pattern.payroll_domain.PaymentClassification;

public class SalariedClassification implements PaymentClassification {

    private final double salary;

    public SalariedClassification(double salary) {
        this.salary = salary;
    }
}
