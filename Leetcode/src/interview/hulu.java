package interview;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class hulu {
	public static String organizeChart(String[] infos) {
		Map<String, List<String>> order = new HashMap<String, List<String>>();
		Map<String, String> remain = new HashMap<String, String>();
		String nameCEO = null;
		for(String info : infos) {
    		String[] parts = info.split(",");
    		String name = parts[0];
    		String boss = parts[1];
    		String title = parts[2];
    		String year = parts[3];
    		
    		if(!remain.containsKey(name)) {
    			remain.put(name, title + " " + year);
    		}
    		
    		if(!order.containsKey(boss)) {
    			order.put(boss, new ArrayList<String>());
    		}
    		if(boss.equals("NULL")) {
    			nameCEO = name;
    		}
    		order.get(boss).add(name);
    	}
		
		StringBuilder sb = new StringBuilder();
		dfs(order, remain, sb, nameCEO, 0);
		return sb.toString();
	}
	
	private static void dfs(Map<String, List<String>> map, Map<String, String> remain, 
			StringBuilder sb, String name, int level) {
		if(name == null) {
			return;
		}
		for(int i = 0; i < level; i++) {
			sb.append("-");
		}
		sb.append(name);
		String info = remain.get(name);
		String[] parts = info.split(" ");
		String title = parts[0];
		String year = parts[1];
		sb.append(" (" + title + ") " + year + "\n");
		if(map.containsKey(name)) {
			Collections.sort(map.get(name));
			for(String next : map.get(name)) {
				dfs(map, remain, sb, next, level + 1);
			}
		}
	}

	public static void main(String[] args) {
		try {
			File fin = new File("org_chart.in");
			PrintWriter pw = new PrintWriter(new FileWriter("org_chart.out"));
			 
			Scanner sc = new Scanner(fin);
	        int caseNum = Integer.valueOf(sc.nextLine());
	        for(int i = 0; i < caseNum; i++) {
	        	String content = sc.nextLine().trim();
	        	String[] infos = content.split("--");
	        	pw.write("Case #" + (i + 1) + "\n");
	        	pw.write(organizeChart(infos));
	        }
	        sc.close();
	        pw.close();
	    } catch (IOException e) {
			e.printStackTrace();
		}
	}
}
