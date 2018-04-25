package agile_principles_practice_pattern.transaction;

import java.util.ArrayList;
import java.util.Date;

import agile_principles_practice_pattern.payroll_domain.Employee;
import agile_principles_practice_pattern.payroll_database.PayrollDatabase;
import agile_principles_practice_pattern.payroll_domain.Transaction;

public class PaydayTransaction implements Transaction {

    @Override
    public void execute() {
//        ArrayList<Integer> empIds = PayrollDatabase.getAllEmployeeIds();
//
//        for (int empId : empIds) {
//            Employee employee = PayrollDatabase.getEmployee(empId);
//
//            if (employee.IsPayDate(payDate)) {
//                Date startDate = employee.getPayPeriodStartDate(payDate);
//                Paycheck pc = new Paycheck(startDate, payDate);
//                paychecks[empId] = pc;
//                employee.Payday(pc);
//            }
//        }
    }
}
