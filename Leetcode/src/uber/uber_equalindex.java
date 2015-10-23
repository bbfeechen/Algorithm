package uber;

//Given an ascending sorted array A of distinct integers, find the index i such that A[i] = i. 
//Return -1 if not exists.
//For example, given A = [-1, 0, 2, 3, 6, 8], return 3 because A[3] = 3.

public class uber_equalindex {
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
	        int middle = start + (end - start)/2;
	        if(A[middle] == middle){
	            return middle;
	        }
	        else if(A[middle] > middle){
	            end = middle - 1;
	        }
	        else{
	            start = middle + 1;
	        }
	    }
	 
	    return -1;
	}
}
