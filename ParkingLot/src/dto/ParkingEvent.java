package dto;

import Enums.ParkingEventType;
import Enums.ParkingSpotEnum;

public class ParkingEvent {
	private ParkingEventType parkingEventType;
	private ParkingSpotEnum parkingSpotEnum;
	public ParkingEvent(ParkingEventType parkingEventType, ParkingSpotEnum parkingSpotEnum) {
		super();
		this.parkingEventType = parkingEventType;
		this.parkingSpotEnum = parkingSpotEnum;
	}
	public ParkingEventType getParkingEventType() {
		return parkingEventType;
	}
	public void setParkingEventType(ParkingEventType parkingEventType) {
		this.parkingEventType = parkingEventType;
	}
	public ParkingSpotEnum getParkingSpotEnum() {
		return parkingSpotEnum;
	}
	public void setParkingSpotEnum(ParkingSpotEnum parkingSpotEnum) {
		this.parkingSpotEnum = parkingSpotEnum;
	}
	

}
