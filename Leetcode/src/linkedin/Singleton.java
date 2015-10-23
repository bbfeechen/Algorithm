package linkedin;

public class Singleton {
	public static class MySingleton {
		private static MySingleton instance = null;
		 
		protected MySingleton() {
		}
		 
		// Lazy Initialization (If required then only)
		public static MySingleton getInstance() {
			if (instance == null) {
				// Thread Safe. Might be costly operation in some case
				synchronized (Singleton.class) {
					if (instance == null) {
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
