package linkedin;

public class Singleton {
	public static class MySingleton {
		private static MySingleton instance = null;
		private MySingleton() {}
		
		public static MySingleton getInstance() {
			if(instance == null) {
				synchronized(MySingleton.class) {
					if(instance == null) {
						instance = new MySingleton();
					}
				}
			}
			return instance;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
