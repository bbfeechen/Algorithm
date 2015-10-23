package snapchat;

import java.util.Arrays;
import java.util.Scanner;

class sudoku {
	public static boolean isValidSudoku(char[][] board) {
        boolean[] isVisited = new boolean[9];
        for(int i = 0; i < 9; i++) {
            Arrays.fill(isVisited, false);
            for(int j = 0; j < 9; j++) {
                if(!visit(board[i][j], isVisited)) {
                    return false;
                }
            }
        }
        
        for(int i = 0; i < 9; i++) {
            Arrays.fill(isVisited, false);
            for(int j = 0; j < 9; j++) {
                if(!visit(board[j][i], isVisited)) {
                    return false;
                }
            }
        }
        
        for(int i = 0; i < 9; i += 3) {
            for(int j = 0; j < 9; j += 3) {
                Arrays.fill(isVisited, false);
                for(int k = 0; k < 9; k++) {
                    if(!visit(board[k / 3 + i][k % 3 + j], isVisited)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private static boolean visit(char digit, boolean[] isVisited) {
        if(digit == '.') {
            return true;
        }
        int num = digit - '0';
        if(num <= 0 || num > 9 || isVisited[num - 1]) {
            return false;
        }
        isVisited[num - 1] = true;
        return true;
    }
    
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	String str = scan.nextLine();
    	char[][] chars = new char[9][9];
    	for(int i = 0; i < 9; i++) {
    		for(int j = 0; j < 9; j++) {
    			chars[i][j] = str.charAt(i * 9 + j);
    		}
    	}
    	System.out.println(isValidSudoku(chars));
    }
}

