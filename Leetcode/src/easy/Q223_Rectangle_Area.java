package easy;

public class Q223_Rectangle_Area {
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int share = 0;
		if(C < E || D < F) {
			share = 0;
		} else {
         share = Math.max(0, Math.min(C, G) - Math.max(A, E)) * Math.max(0, Math.min(D, H) - Math.max(B, F));
		}
		return ((C - A) * (D - B) + (G - E) * (H - F)) - share;
	}

	public static void main(String[] args) {
		System.out.println(computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1));
	}
}
