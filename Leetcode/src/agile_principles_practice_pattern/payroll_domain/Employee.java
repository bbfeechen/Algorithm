package agile_principles_practice_pattern.payroll_domain;

import agile_principles_practice_pattern.affiliations.NoAffiliation;

public class Employee {
    private final int empid;
    private final String address;
    private String name;
    private PaymentClassification classification;
    private PaymentSchedule schedule;
    private PaymentMethod method;

    private Affiliation affiliation = new NoAffiliation();

    public Employee(int empid, String address, String name) {
        this.empid = empid;
        this.address = address;
        this.name = name;
    }

    public int getEmpid() {
        return empid;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public PaymentClassification getClassification() {
        return classification;
    }

    public PaymentSchedule getSchedule() {
        return schedule;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassification(PaymentClassification classification) {
        this.classification = classification;
    }

    public void setSchedule(PaymentSchedule schedule) {
        this.schedule = schedule;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public void setAffiliation(Affiliation affiliation) {
        this.affiliation = affiliation;
    }

//    public void Payday(Paycheck paycheck) {
//        double grossPay = classification.calculatePay(paycheck);
//        double deductions =
//                affiliation.calculateDeductions(paycheck);
//        double netPay = grossPay - deductions;
//        paycheck.GrossPay = grossPay;
//        paycheck.Deductions = deductions;
//        paycheck.NetPay = netPay;
//        method.Pay(paycheck);
//    }
}
