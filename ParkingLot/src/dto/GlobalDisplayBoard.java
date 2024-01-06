package dto;

import java.util.HashMap;

import Enums.ParkingSpotEnum;

public class GlobalDisplayBoard {
	//This should be singleton
    private static GlobalDisplayBoard globalDisplayBoard = null;
    
    //Logic for populating this map is not written here 
    private HashMap<ParkingSpotEnum, Integer> freeParkingSpot = new HashMap<>();
    //Singleton Pattern
    public static GlobalDisplayBoard getInstance()
    {
    	if(globalDisplayBoard==null)
    	{
    		globalDisplayBoard =  new GlobalDisplayBoard();
    	}
    	return globalDisplayBoard;
    }
	public HashMap<ParkingSpotEnum, Integer> getFreeParkingSpot() {
		return freeParkingSpot;
	}
	public void setFreeParkingSpot(HashMap<ParkingSpotEnum, Integer> freeParkingSpot) {
		this.freeParkingSpot = freeParkingSpot;
	}
	

}
