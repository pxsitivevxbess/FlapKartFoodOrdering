package dto;

import java.util.ArrayList;

import dto.parkingSpot.ParkingSpot;

//Dont think there is any use for this
public class Floor {
	private int floor;
	private ArrayList<ParkingSpot> parkings = new ArrayList<>();
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public ArrayList<ParkingSpot> getParkings() {
		return parkings;
	}
	public void setParkings(ArrayList<ParkingSpot> parkings) {
		this.parkings = parkings;
	}
	@Override
	public String toString() {
		return "Floor [floor=" + floor + ", parkings=" + parkings + "]";
	}
	

}
