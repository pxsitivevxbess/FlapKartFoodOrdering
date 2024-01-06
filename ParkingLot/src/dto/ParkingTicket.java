package dto;

import java.util.concurrent.atomic.AtomicInteger;

import Enums.PaymentMethod;
import Enums.PaymentStatus;
import Enums.ParkingSpotEnum;
import dto.parkingSpot.ParkingSpot;

public class ParkingTicket {
	private static final AtomicInteger x = new AtomicInteger(0);//Helps in generating unique id which is thread safe for each parking spot
	private int id;
	private long timeStamp;
	private ParkingSpotEnum vehicle;
	private ParkingSpot parkingSpot;
	private PaymentStatus paymentStatus;
	private PaymentMethod paymentMethod;
	public ParkingTicket( long timeStamp, ParkingSpotEnum vehicle, ParkingSpot parkingSpot) {
		super();
		this.id = x.incrementAndGet();
		this.timeStamp = System.currentTimeMillis();
		this.vehicle = vehicle;
		this.parkingSpot = parkingSpot;
		this.paymentStatus = PaymentStatus.Pending;
		this.paymentMethod=null;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	@Override
	public String toString() {
		return "ParkingTicket [id=" + id + ", timeStamp=" + timeStamp + ", vehicle=" + vehicle + ", parkingSpot="
				+ parkingSpot + ", paymentStatus=" + paymentStatus + ", paymentMethod=" + paymentMethod + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public ParkingSpotEnum getVehicle() {
		return vehicle;
	}
	public void setVehicle(ParkingSpotEnum vehicle) {
		this.vehicle = vehicle;
	}
	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}
	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}
	

}
