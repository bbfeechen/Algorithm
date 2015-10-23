package snapchat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class printinfo {
	public static class People {
		private String name;
		private String doj;
		public People (String name, String doj) {
			this.name = name;
			this.doj = doj;
		}
		
		public String getName() {
			return this.name;
		}
	}
	
	public static void main(String[] args) {
		printinfo sol = new printinfo();
		List<String> input = new ArrayList<String>();
		input.add("BALLMER,STEVE,3/2/1982,BILL GATES");
		input.add("JOBS,STEVE,12/11/1992,BILL GATES");
		input.add("PAGE,LARRY,1/8/1977,STEVE BALLMER");
		input.add("GATES,BILL,1/8/1977,BILL GATES");
		Map<String, List<People>> sub = new HashMap<String, List<People>>();
		
		String ceo = null;
		for (String s : input) {
			String[] tokens = s.split(",");
			String name = tokens[1] + " " + tokens[0];
			People people = new People (name, tokens[2]);
			String boss = tokens[3];
			if (name.equals(boss)) ceo = boss; 
			else if (sub.containsKey(boss)) {
				List<People> list = sub.get(boss);
				list.add(people);
				sub.put(boss, list);
			} else {
				List<People> list = new ArrayList<People>();
				list.add(people);
				sub.put(boss, list);
			}
		}
		
		sol.print(ceo, sub, ">");
		
	}
	
	public void print(String name, Map<String, List<People>> sub, String div) {
		System.out.println(div + name);
		if (sub.containsKey(name)) {
			for (People p : sub.get(name)) {
				print(p.getName(), sub, div + ">");
			}
		}
	}
}
