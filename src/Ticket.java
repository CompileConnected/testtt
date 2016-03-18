
public class Ticket {
	String transactionId, vehicleType, 
	comingTime, policeNumber, date;
	int price, spotId, floor;
	
	public Ticket(String transactionId, String vehicleType, int price
			, String comingTime, String policeNumber, String date, int spotId, int floor) {
		this.transactionId = transactionId;
		this.vehicleType = vehicleType;
		this.price = price;
		this.comingTime = comingTime;
		this.policeNumber = policeNumber;
		this.date = date;
		this.spotId = spotId;
		this.floor = floor;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public String getComingTime() {
		return comingTime;
	}


	public String getPoliceNumber() {
		return policeNumber;
	}

	public int getPrice() {
		return price;
	}

	public String getDate() {
		return date;
	}
	
}
