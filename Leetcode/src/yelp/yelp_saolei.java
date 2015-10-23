package yelp;

import java.util.Random;

public class yelp_saolei {
	public static void main(String args[]){
		Random r = new Random();				
		int n = 4;							
		int[][] board = new int[n][n];
		
		for(int i = 0; i < r.nextInt(1000); i++){
			board[r.nextInt(n)][r.nextInt(n)] = 9;								
		}
        //下面进行判断，思路：遍历“地雷”位置，找到后对其附近的数组进行加1操作
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j] > 8) {
					if(j > 0) {				//保证列不越界
						board[i][j-1]++;
					}
					if(j < board[i].length - 1) {
						board[i][j+1]++;
					}
					if(i > 0) {				//上一行
						board[i-1][j]++;
						if(j > 0) {
							board[i-1][j-1]++;
						}
						if(j < board[i].length-1) {
							board[i-1][j+1]++;
						}
					}
					if(i < n - 1) {			//下一行
						board[i+1][j]++;
						if(j > 0) {
							board[i+1][j-1]++;
						}
						if(j < board[i].length-1) {
							board[i+1][j+1]++;
						}
					}
				}
			}
		}
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(board[i][j] >= 9)
					System.out.print(" * ");
				else
					System.out.print(" " + board[i][j] + " ");
			}
			System.out.println();
		}
	}
	//
	//输出结果：
	//0  0  0  0  0  0  1  *  2  2  *  2  *  *  1 
	//1  1  1  1  1  2  2  3  *  2  2  3  4  4  3 
	//1  *  1  1  *  2  *  3  2  1  1  *  2  *  * 
	//1  1  1  1  1  3  4  *  3  1  3  2  3  2  2 
	//1  1  1  0  0  2  *  *  4  *  2  *  1  0  0 
	//1  *  1  0  0  2  *  *  4  3  4  2  1  0  0 
	//1  1  1  1  1  2  2  2  2  *  *  1  0  1  1 
	//1  1  1  1  *  2  1  1  1  2  3  2  2  2  * 
	//2  *  1  1  1  2  *  1  0  0  1  *  2  *  2 
	//*  2  2  1  2  3  3  3  1  1  1  1  2  1  1 
	//1  1  2  *  3  *  *  3  *  2  0  0  1  1  1 
	//0  1  3  *  4  3  3  4  *  4  1  0  1  *  2 
	//1  2  *  2  2  *  2  3  *  *  2  0  1  3  * 
	//*  5  3  2  1  2  3  *  4  *  3  1  1  4  * 
	//*  *  *  1  0  1  *  2  2  2  *  1  1  *  * 
}
