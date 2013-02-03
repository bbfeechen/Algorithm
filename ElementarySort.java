public class ElementarySort {
	public static void sort(Comparable[] a) { 
		StdOut.println("shellSort is used!");
		shellSort(a); 
	}
	public static boolean isSorted(Comparable[] a) {
		for(int i = 1; i < a.length; i++) {
			if(less(a[i], a[i-1]))
				return false;
		}
		return true;
	}
	
	// Sort Algorithm
	private static void selectionSort(Comparable[] a) {
		int N = a.length;
		for(int i = 0; i < N; i++) {
			int min = i;
			for(int j = i+1; j < N; j++)
				if(less(a[j], a[min])) min = j;
			exch(a, i, min);
		}
	}
	
	private static void insertionSort(Comparable[] a) {
		int N = a.length;
		for(int i = 1; i < N; i++) {
			for(int j = i; j > 0 && less(a[j], a[j-1]); j--) 
				exch(a, j, j-1);
		}
	}
	
	private static void shellSort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while(h < N/3) h = 3*h + 1;
		while(h >= 1) {
			for(int i = h; i < N; i++) {
				for(int j = i; j >= h && less(a[j], a[j-h]); j -= h)
					exch(a, j, j-h);
			}
			h = h/3;
		}
	}
	
	private static boolean less(Comparable v, Comparable w) { return v.compareTo(w) < 0; }
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	private static void show(Comparable[] a) {
		for(int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}
	
	public static void main(String[] args) {
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}