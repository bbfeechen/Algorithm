package snapchat;

public class FloodFill {
	private static void floodFillUtil(int[][] screen, int x, int y, int prevC, int newC)
	{
		int M = screen.length;
		int N = screen[0].length;
	    // Base cases
	    if (x < 0 || x >= M || y < 0 || y >= N)
	        return;
	    if (screen[x][y] != prevC)
	        return;
	 
	    // Replace the color at (x, y)
	    screen[x][y] = newC;
	 
	    // Recur for north, east, south and west
	    floodFillUtil(screen, x+1, y, prevC, newC);
	    floodFillUtil(screen, x-1, y, prevC, newC);
	    floodFillUtil(screen, x, y+1, prevC, newC);
	    floodFillUtil(screen, x, y-1, prevC, newC);
	}
	
	public static void floodFill(int[][] screen, int x, int y, int newC)
	{
	    int prevC = screen[x][y];
	    floodFillUtil(screen, x, y, prevC, newC);
	}

	public static void main(String[] args) {
		int[][] screen = {
				{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
                };
		int x = 4, y = 4, newC = 3;
		floodFill(screen, x, y, newC);
		
		int M = screen.length;
		int N = screen[0].length;
	    System.out.println("Updated screen after call to floodFill:");
	    for (int i = 0; i < M; i++)
	    {
	        for (int j = 0; j < N; j++)
	           System.out.print(screen[i][j] + " ");
	        System.out.println();
	    }
	}
}
