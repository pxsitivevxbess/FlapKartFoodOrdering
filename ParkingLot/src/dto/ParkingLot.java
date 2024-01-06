package dto;

import java.util.ArrayList;
import java.util.HashMap;

import Enums.ParkingSpotEnum;

public class ParkingLot {

	//Singleton Parking Lot
	private static ParkingLot parkingLot = null;
	private ArrayList<EntrancePanel> entrancePanels = new ArrayList<>();
	private ArrayList<ExitPanel> exitPanels = new ArrayList<>();
	private HashMap<ParkingSpotEnum, Integer> freeParking = new HashMap<>();
	private HashMap<ParkingSpotEnum, Integer> occupiedParking = new HashMap<>();
	
	public static ParkingLot getIstance()
	{
		if(parkingLot==null)
		{
			parkingLot = new ParkingLot();
		}
		return parkingLot;
	}
	public ArrayList<EntrancePanel> getEntrancePanels() {
		return entrancePanels;
	}

	public void setEntrancePanels(ArrayList<EntrancePanel> entrancePanels) {
		this.entrancePanels = entrancePanels;
	}

	public ArrayList<ExitPanel> getExitPanels() {
		return exitPanels;
	}

	public void setExitPanels(ArrayList<ExitPanel> exitPanels) {
		this.exitPanels = exitPanels;
	}

	public HashMap<ParkingSpotEnum, Integer> getFreeParking() {
		return freeParking;
	}

	public void setFreeParking(HashMap<ParkingSpotEnum, Integer> freeParking) {
		this.freeParking = freeParking;
	}

	public HashMap<ParkingSpotEnum, Integer> getOccupiedParking() {
		return occupiedParking;
	}

	public void setOccupiedParking(HashMap<ParkingSpotEnum, Integer> occupiedParking) {
		this.occupiedParking = occupiedParking;
	}
	
}
