package medium;

import java.util.Stack;

public class Q71_Simplify_Path {
	public static String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<String>();
        
        for(String str : strs) {
            if(!str.equals(".") && !str.equals("")) {
                if(str.equals("..")) {
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(str);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

	public static void main(String[] args) {
		String path = "/a/./b/../../c/";
		System.out.println(simplifyPath(path));
	}
}
