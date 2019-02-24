package medium;

public class Q533_Lonely_Pixel_II {
    public static int findBlackPixel(char[][] picture, int N) {
        int rowCount = picture.length;
        int colCount = picture[0].length;
        int[] row = new int[rowCount];
        int[] col = new int[colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (isValid(picture, row, col, i, j, N)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isValid(char[][] picture, int[] row, int[] col, int i, int j, int N) {
        if (picture[i][j] != 'B' || row[i] != N || col[j] != N) {
            return false;
        }
        String prev = null;
        for (int k = 0; k < row.length; k++) {
            if (picture[k][j] != 'B') {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (char c : picture[k]) {
                sb.append(c);
            }
            if (prev != null && !prev.equals(sb.toString())) {
                return false;
            } else if (prev == null) {
                prev = sb.toString();
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] picture = {
                {'W', 'B', 'W', 'B', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'B', 'W'},
                {'W', 'W', 'B', 'W', 'B', 'W'}};
        System.out.println(findBlackPixel(picture, 3));
    }
}
