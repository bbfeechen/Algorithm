package interview;

public class ixl_learning_1 {
	public static void switchOnOff1() {
		boolean[] isON = new boolean[100];
		for(int i = 0; i < 100; i++) {
			isON[i] = true;
		}
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if((j + 1) % (i + 1) == 0) {
					isON[j] = (!isON[j] ? true : false);
				}
			}
		}
		for(int i = 0; i < 100; i++) {
			if(!isON[i]) {
				System.out.print((i + 1) + " ");
			}
		}
		System.out.println();
	}
	
	public static void switchOnOff2() {
		for(int i = 1; i <= Math.sqrt(100); i++) {
			System.out.print((i * i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		switchOnOff1();
		switchOnOff2();
	}

}
