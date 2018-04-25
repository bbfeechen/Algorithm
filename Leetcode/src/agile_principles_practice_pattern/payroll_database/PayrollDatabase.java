package agile_principles_practice_pattern.payroll_database;

import java.util.HashMap;
import java.util.Map;

import agile_principles_practice_pattern.payroll_domain.Employee;

public class PayrollDatabase {
    private static Map<Integer, Employee> employees = new HashMap<>();

    public static void addEmployee(int id, Employee employee) {
        employees.put(id, employee);
    }

    public static void deleteEmployee(int id) {
        employees.remove(id);
    }

    public static Employee getEmployee(int id) {
        return employees.get(id);
    }

    public static void addUnionMember(int memberId, Employee employee) {

    }

    public static void removeUnionMember(int memberId) {

    }

//    public static Employee getUnionMember(int memberId) {
//
//    }
}
