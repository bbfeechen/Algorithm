package linkedin;

//	Given an ascending sorted array A of distinct integers, find the index i such that A[i] = i. 
//	Return -1 if not exists.
//	For example, given A = [-1, 0, 2, 3, 6, 8], return 2 because A[2] = 2.

public class Equalindex {
	public static int search(int[] A){
	    if(A.length == 0){
	        return -1;
	    }
	 
	    int start = 0;
	    int end = A.length - 1;
	 
	    if(A[start] - start > 0 || A[end] - end < 0){
	        return -1;
	    }
	 
	    while(start <= end){
	        int mid = start + (end - start)/2;
	        if(A[mid] == mid){
	            return mid;
	        }
	        else if(A[mid] > mid){
	            end = mid - 1;
	        }
	        else{
	            start = mid + 1;
	        }
	    }
	 
	    return -1;
	}
	
	public static void main(String[] argv) {
		int[] A = {-1, 0, 2, 3, 6, 8};
		System.out.println(search(A));
	}
}
