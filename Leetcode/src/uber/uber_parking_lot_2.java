package uber;

import java.util.Date;
import java.util.List;

public class uber_parking_lot_2 {
	public class Vehicle {
		int mID;
		int mParkingSize;
		ParkingTicket mParkingTicket;
		
		public void parkIn(ParkingManager manager) {
		}
		
		public void moveOut(ParkingManager manager) {
		}
	}
	
	public class Motorcycle extends Vehicle {
		public Motorcycle() {
			mParkingSize = 1;
		}
	}
	
	public class Car extends Vehicle {
		public Car() {
			mParkingSize = 2;
		}
	}
	
	public class ParkingSpot {
		int mID;
		int mParkingSpotSize;
		boolean mAvailable;
	}
	
	public class ParkingLot {
		int mID;
		List<ParkingSpot> mParkingSpotList;
	}
	
	public class ParkingTicket {
		int mID;
		ParkingSpot mParkingSpot;
		Vehicle mVehicle;
		Date mEnterTime;
		Date mLeaveTime;
	}
	
	public class ParkingManager {
		ParkingLot mParkingLot;
		List<ParkingTicket> mParkingTicketList;
		
		public ParkingSpot findParkingSpot(int size) { return null; };
		public ParkingTicket generateParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) { return null; };
		public void withdrawParkingTicket(int ParkingTicketID) {};
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
