package uber;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class uber_parking_lot_1 {
	public class ParkingLot 
	{
	    List<ParkingSpace> vacantParkingSpaces = null;
	    List<ParkingSpace> fullParkingSpaces = null;

	    int parkingSpaceCount = 0;

	    boolean isFull;
	    boolean isEmpty;
	    
	    public ParkingLot() {
	    	vacantParkingSpaces = new ArrayList<ParkingSpace>();
	    	fullParkingSpaces = new ArrayList<ParkingSpace>();
	    }

	    ParkingSpace findNearestVacant(ParkingType type)
	    {
	        Iterator<ParkingSpace> itr = vacantParkingSpaces.iterator();

	        while(itr.hasNext())
	        {
	            ParkingSpace parkingSpace = itr.next();

	            if(parkingSpace.parkingType == type)
	            {
	                return parkingSpace;
	            }
	        }
	        return null;
	    }

	    void parkVehicle(ParkingType type, Vehicle vehicle)
	    {
	        if(!isFull())
	        {
	            ParkingSpace parkingSpace = findNearestVacant(type);

	            if(parkingSpace != null)
	            {
	                parkingSpace.vehicle = vehicle;
	                parkingSpace.isVacant = false;

	                vacantParkingSpaces.remove(parkingSpace);
	                fullParkingSpaces.add(parkingSpace);

	                if(fullParkingSpaces.size() == parkingSpaceCount)
	                    isFull = true;

	                isEmpty = false;
	            }
	        }
	    }

	    void releaseVehicle(Vehicle vehicle)
	    {
	        if(!isEmpty())
	        {
	            Iterator<ParkingSpace> itr = fullParkingSpaces.iterator();

	            while(itr.hasNext())
	            {
	                ParkingSpace parkingSpace = itr.next();

	                if(parkingSpace.vehicle.equals(vehicle))
	                {
	                    fullParkingSpaces.remove(parkingSpace);
	                    vacantParkingSpaces.add(parkingSpace);

	                    parkingSpace.isVacant = true;
	                    parkingSpace.vehicle = null;

	                    if(vacantParkingSpaces.size() == parkingSpaceCount)
	                        isEmpty = true;

	                    isFull = false;
	                }
	            }
	        }
	    }

	    boolean isFull()
	    {
	        return isFull;
	    }

	    boolean isEmpty()
	    {
	        return isEmpty;
	    }
	}

	public class ParkingSpace 
	{
	    boolean isVacant;
	    Vehicle vehicle;
	    ParkingType parkingType;
	    int distance;
	}

	public class Vehicle 
	{
	    int num;
	}

	public enum ParkingType
	{
	    REGULAR,
	    HANDICAPPED,
	    COMPACT,
	    MAX_PARKING_TYPE,
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
