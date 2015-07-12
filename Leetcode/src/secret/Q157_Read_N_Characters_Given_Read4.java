package secret;

public class Q157_Read_N_Characters_Given_Read4 {
	public int read4(char[] buf) {
		return 4;
	}
	
	public int read(char[] buf, int n) {
		char[] buffer = new char[4];  
        
        boolean lessthan4 = false;  
        int Readbyte = 0;  
        int bytes = 0;  
          
        while(!lessthan4 && Readbyte<n){  
            int size = read4(buffer);  
            if(size<4){  
                lessthan4 = true;  
            }  
              
            bytes = Math.min(n-Readbyte,size);  
            for(int i=0; i<bytes; i++){  
                buf[Readbyte+i] = buffer[i];  
            }  
            Readbyte += bytes;  
        }  
        return Readbyte;  
	}
	
	public static void main(String[] args) {

	}
}
