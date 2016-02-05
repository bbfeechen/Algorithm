package snapchat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeePrinter {
	public static class Employee {
		String name;
		String date;
		public Employee(String name, String date) {
			this.name = name;
			this.date = date;
		}
	}
	
	public static void print(String name, Map<String, List<Employee>> map, String delimiter) {
		System.out.println(delimiter + name);
		if(map.containsKey(name)) {
			for(Employee employee : map.get(name)) {
				print(employee.name, map, delimiter + delimiter);
			}
		}
	}

	public static void main(String[] args) {
		EmployeePrinter ep = new EmployeePrinter();
		
		List<String> info = new ArrayList<String>();
		info.add("BALLMER,STEVE, 3/2/1982, BILL GATES");
		info.add("JOBS,STEVE, 12/11/1992, BILL GATES");
		info.add("PAGE,LARRY, 1/8/1977, STEVE BALLMER");
		info.add("GATES,BILL, 1/8/1977, BILL GATES");
		
		Map<String, List<Employee>> map = new HashMap<String, List<Employee>>();
		String CEO = null;
		for(String input : info) {
			String[] tokens = input.trim().split(",");
			String name = tokens[1].trim() + " " + tokens[0].trim();
			String date = tokens[2].trim();
			String boss = tokens[3].trim();
			if(name.equals(boss)) {
				CEO = name;
			} else if(!map.containsKey(boss)) {
				map.put(boss, new ArrayList<Employee>());
				map.get(boss).add(new Employee(name, date));
			} else {
				map.get(boss).add(new Employee(name, date));
			}
		}
		print(CEO, map, ">");
	}
}
