package uber;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;


public class uber_messagedispatcher {
	//-----------------
	public static class Customer {
		public Customer() {
		}
	}
	
	public static class Driver {
		public Driver() {
		}
	}
	
	public static interface Event<L> {
	   public void notify(L listener);
	}
	
	public static class PickupListener {
		public void pickup(Driver driver, Customer customer) {
			// do something
		}
	}

	public static class Pickup implements Event<PickupListener> {
	   private final Driver driver;
	   private final Customer customer;

	   public Pickup(Driver driver, Customer customer) {
	      this.driver = driver;
	      this.customer = customer;
	   }

	   public void notify(PickupListener listener) {
	      listener.pickup(driver, customer);
	   }
	}

	//-----------------
	public static class MessageDispatcher {

	   /** mapping of class events to active listeners **/
	   private ConcurrentHashMap<Class, ArrayList> map;
	   
	   public MessageDispatcher(int capacity) {
		   map = new ConcurrentHashMap<Class, ArrayList >(capacity);
	   }

	   /** Add a listener to an event class **/
	   public <L> void register( Class<? extends Event<L>> evtClass, L listener) {
	      final ArrayList<L> listeners = listenersOf( evtClass );
	      synchronized( listeners ) {
	         if ( !listeners.contains( listener ) ) {
	            listeners.add( listener );
	         }
	      }
	   }

	    /** Stop sending an event class to a given listener **/
	    public <L> void unregister( Class<? extends Event<L>> evtClass, L listener) {
	      final ArrayList<L> listeners = listenersOf( evtClass );
	      synchronized( listeners ) {
	         listeners.remove( listener );
	      }
	   }

	   /** Gets listeners for a given event class **/
	   private <L> ArrayList<L> listenersOf(Class<? extends Event<L>> evtClass) {
	      synchronized (map) {
	         ArrayList<L> existing = map.get( evtClass );
	         if (existing != null) {
	            return existing;
	         }

	         ArrayList<L> emptyList = new ArrayList<L>(5);
	         map.put(evtClass, emptyList);
	         return emptyList;
	      }
	   }


	   /** Notify a new event to registered listeners of this event class **/
	   public <L> void notify(Event<L> evt) {
	      Class<Event<L>> evtClass = (Class<Event<L>>) evt.getClass();
	      for ( L listener : listenersOf(  evtClass ) ) {
	         evt.notify(listener);
	      }
	   }
	}

	public static void main(String[] args) {
		//-----------------
		// A unique dispatcher
		MessageDispatcher dispatcher = new MessageDispatcher(100);

		// Somewhere, an observer is interested by pickup events 
		PickupListener observer = new PickupListener();
		dispatcher.register(Pickup.class, observer);

		// there is some moving parts        
		Driver driver = new Driver();
		Customer customer = new Customer();

		// Later they collide => a pickup event is notified trough the dispatcher
		dispatcher.notify( new Pickup(driver, customer));
	}
}
