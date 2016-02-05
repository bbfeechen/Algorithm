package secret;

public class Q302_Smallest_Rectangle_Enclosing_Black_Pixels {
	private static int minX = Integer.MAX_VALUE;
	private static int minY = Integer.MAX_VALUE;
	private static int maxX = 0;
	private static int maxY = 0;
	
    public static int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0 || image[0].length == 0) return 0;
        dfs(image, x, y);
        return(maxX - minX + 1) * (maxY - minY + 1);
    }
    private static void dfs(char[][] image, int x, int y){
        int m = image.length, n = image[0].length;
        if(x < 0 || y < 0 || x >= m || y >= n || image[x][y] == '0') return;
        image[x][y] = '0';
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);
        dfs(image, x + 1, y);
        dfs(image, x - 1, y);
        dfs(image, x, y - 1);
        dfs(image, x, y + 1);
    }

	public static void main(String[] args) {
		char[][] image = {
				{'0', '0', '0', '1', '1', '1', '0', '0', '0'},
				{'0', '0', '0', '1', '0', '1', '0', '0', '0'},
				{'0', '0', '0', '1', '0', '1', '1', '0', '0'},
				{'0', '0', '1', '1', '0', '0', '1', '0', '0'},
		};
	}
}
