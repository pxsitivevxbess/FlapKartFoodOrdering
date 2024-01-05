package dto.parkingSpot;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class ParkingSpot {
	//AtomicInteger is a class in Java that provides atomic operations for integer values
	//Here x is instance of AtomicInteger Class, which is static and final
	//So point is x as object(memory address) is static
	private static final AtomicInteger x = new AtomicInteger(0);//Helps in generating unique id which is thread safe for each parking spot
	private int id;
	private int floor;
	private boolean isFree;
	private int hourlyRate;
	public ParkingSpot(int floor, int hourlyRate) {
		super();
		this.id = x.incrementAndGet();//The final keyword, in this context,
		//means that the reference to the AtomicInteger cannot be changed once it's assigned.
		//However, the content of the AtomicInteger (its internal state, like the value it holds) 
		//can still be modified.
		this.floor = floor;
		this.isFree = true;
		this.hourlyRate = hourlyRate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public boolean isFree() {
		return isFree;
	}
	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}
	public int getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
}
