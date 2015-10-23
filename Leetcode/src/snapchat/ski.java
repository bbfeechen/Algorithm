package snapchat;

public class ski {
	private static int M = 5;
	private static int N = 5;
	private static int a[][] = {
		{0,  0,  0,  0,  0,  0,  0},
		{0,  1,  2,  3,  4,  5,  0},
		{0, 16, 17, 18, 19,  6,  0},
		{0, 15, 24, 25, 20,  7,  0},
		{0, 14, 23, 22, 21,  8,  0},
		{0, 13, 12, 11, 10,  9,  0},
		{0,  0,  0,  0,  0,  0,  0}
	};
	
	private static int vis[][] = {
		{0,  0,  0,  0,  0,  0,  0},
		{0,  0,  0,  0,  0,  0,  0},
		{0,  0,  0,  0,  0,  0,  0},
		{0,  0,  0,  0,  0,  0,  0},
		{0,  0,  0,  0,  0,  0,  0},
		{0,  0,  0,  0,  0,  0,  0},
		{0,  0,  0,  0,  0,  0,  0}
	};
	
	private static int search(int i, int j) {
        int sum = 0;
        if(i < 1 || i > N || j < 1 || j > M) {
			return 0;
		}
		if(vis[i][j] != 0) {
			return vis[i][j];
		}
		if(a[i][j] > a[i - 1][j]) { //下
		    sum = Math.max(sum, search(i - 1, j));
		}
		if(a[i][j] > a[i][j - 1]) { //左
			sum = Math.max(sum, search(i, j - 1));
		}
		if(a[i][j] > a[i][j + 1]) { //右
			sum = Math.max(sum, search(i, j + 1));
		}
		if(a[i][j] > a[i + 1][j]) { //上
			sum = Math.max(sum, search(i + 1, j));
		}
		 
		return vis[i][j] = sum + 1;//递归到一个数组元素查找最长轨迹结束才返回最终的值！
	}
	
	public static void main(String[] args) {
		int max = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				max = Math.max(max, search(i, j));
			}
		}
		System.out.println(max);
	}
}
