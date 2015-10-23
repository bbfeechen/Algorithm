package linkedin;

public class PrintFactorOfNum {
	public static void printAllFactors(int num) {
	    int factorCandidate;
	    for(factorCandidate = 1; factorCandidate <= num/2; factorCandidate++) {
	        if(num%factorCandidate == 0)
	            System.out.print(factorCandidate + " ");
	    }
	}

	public static void main(String[] args) {
		printAllFactors(12);
	}
}
