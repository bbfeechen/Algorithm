package interview;


public class Monitor {
	public static final int PHILOSOPHER_NUM = 5;
	public static final int CHOPSTICK_NUM = 5;
	public static final int ACTION_TIMES = 10;
	
	private enum State {
		THINKING, 
		HUNGRY, 
		EATING
	}
	
	private Object[] locks = new Object[PHILOSOPHER_NUM];
	private State[] states = new State[PHILOSOPHER_NUM];
	
	public Monitor() {
	    for (int i = 0; i < PHILOSOPHER_NUM; i++) {
	    	this.locks[i] = new Object();
	        this.states[i] = State.THINKING;
	        System.out.println("Philosopher " + i + " is " + "THINKING");
	    }
	}
	
	public synchronized void pickup(int i) {
	    this.states[i] = State.HUNGRY;
	    System.out.println("Philosopher " + i + " is " + "HUNGRY");
	
	    changeState(i);
	    if (this.states[i] != State.EATING) {
	        try {
	            System.out.println("Philosopher " + i + " is " + "WAITING");
	            synchronized (locks[i]) {
	            	locks[i].wait();
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public synchronized void putdown(int i) {
	    this.states[i] = State.THINKING;
	    System.out.println("Philosopher " + i + " is " + "THINKING");
	
	    changeState((i + PHILOSOPHER_NUM - 1) % PHILOSOPHER_NUM);
	    changeState((i + 1) % PHILOSOPHER_NUM);
	}
	
	private void changeState(int i) {
	    if(this.states[(i + PHILOSOPHER_NUM - 1) % PHILOSOPHER_NUM] != State.EATING &&
	       this.states[i] == State.HUNGRY &&
	       this.states[(i + 1) % PHILOSOPHER_NUM] != State.EATING) {
	       
	    	this.states[i] = State.EATING;
	    	System.out.println("Philosopher " + i + " is " + "EATING");
	
	    	synchronized (locks[i]) {
	    		locks[i].notifyAll();
	        }
	    }
	}
	
	public static class Philosopher implements Runnable {
		private Monitor monitor;
		private int chopstickID;
		
		public Philosopher(Monitor monitor, int i) {
		    this.monitor = monitor;
		    this.chopstickID = i;
		}
		
		@Override
		public void run() {
		    for (int j = 0; j < ACTION_TIMES; j++) {
		        monitor.pickup(chopstickID);
		        try { 
		        	Thread.sleep(1000); 
		        }catch (InterruptedException e) {
		        	e.printStackTrace();
		        }
		        monitor.putdown(chopstickID);
		    }
		}
	}
	
	public static void main(String[] args) {
	    Monitor monitor = new Monitor();
	    for (int i = 0; i < Monitor.CHOPSTICK_NUM; i++) {
	        new Thread(new Philosopher(monitor, i)).run();
	    }
	}
}