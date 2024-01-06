package dto;

import java.util.concurrent.atomic.AtomicInteger;

public class ExitPanel {

	private static final AtomicInteger x = new AtomicInteger(0);//Helps in generating unique id which is thread safe for each parking spot
	private int id;
	private int floor;
	public ExitPanel(int floor)
	{
		this.floor = floor;
		id = x.incrementAndGet();
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
	public static AtomicInteger getX() {
		return x;
	}
}
