package secret;

import java.util.ArrayList;
import java.util.List;

public class Q251_Flatten_2D_Vector {
	public static class Vector2D {
	     
	    private List<List<Integer>> vec2d;
	    private int rowId;
	    private int colId;
	    private int numRows;
	     
	    public Vector2D(List<List<Integer>> vec2d) {
	        this.vec2d = vec2d;
	        rowId = 0;
	        colId = 0;
	        numRows = vec2d.size();
	    }
	 
	    public int next() {
	        int ans = 0;
	        if (colId < vec2d.get(rowId).size()) {
	            ans = vec2d.get(rowId).get(colId);
	        }
	         
	        colId++;
	        if (colId == vec2d.get(rowId).size()) {
	            colId = 0;
	            rowId++;
	        }
	         
	        return ans;
	    }
	 
	    public boolean hasNext() {
	        while (rowId < numRows && (vec2d.get(rowId) == null || vec2d.get(rowId).isEmpty())) {
	            rowId++;
	        }
	         
	        return vec2d != null && 
	        !vec2d.isEmpty() &&
	        rowId < numRows;
	    }
	}

	public static void main(String[] args) {
		List<List<Integer>> vec2d = new ArrayList<List<Integer>>();
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(4);
		list3.add(5);
		list3.add(6);
		vec2d.add(list1);
		vec2d.add(list2);
		vec2d.add(list3);
		Vector2D i = new Vector2D(vec2d);
		while (i.hasNext()) { 
			System.out.println(i.next());
		}
	}
}
