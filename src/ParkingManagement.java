import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public class ParkingManagement {
	
	int spotId;
	String arrivalTime, arrivalDate, transactionId;
	ArrayList<Ticket> ticketBox = new ArrayList<Ticket>();
	int priceForBike = 2000, priceForCar = 5000,
			priceForBus = 7000;
	
	public ParkingManagement() {
		
	}
	
	public int assignVehicleToSpot(Vehicle vehicle){
		ParkingSpace space = new ParkingSpace();
		spotId = space.addToParkingSpace(vehicle);
		return spotId;
		
	}
	
	public Ticket createTicket(Vehicle vehicle){
		Ticket ticket = null;
		Random rand = new Random();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dfTime = new SimpleDateFormat("HH:mm");
		arrivalTime = dfTime.format(new Date());
		arrivalDate = df.format(new Date());
		
		if (vehicle.getVechicleCategory().equals("motor")){
			transactionId = "MTR"+rand.nextInt(3);
			ticket = new Ticket(transactionId, vehicle.getVechicleCategory(), priceForBike
					, arrivalTime, vehicle.getNomorPolisi(), arrivalDate, spotId, 0);
		}else if (vehicle.getVechicleCategory().equals("mobil")){
			transactionId = "MBL"+rand.nextInt(3);
			ticket = new Ticket(transactionId, vehicle.getVechicleCategory(), priceForCar
					, arrivalTime, vehicle.getNomorPolisi(), arrivalDate, spotId, 0);
		}else if (vehicle.getVechicleCategory().equals("bus")){
			transactionId = "MBL"+rand.nextInt(3);
			ticket = new Ticket(transactionId, vehicle.getVechicleCategory(), priceForBus
					, arrivalTime, vehicle.getNomorPolisi(), arrivalDate, spotId, 0);
		}
		ticketBox.add(ticket);
		return ticket;
	}
	
	public int getCount(String category){
		int count = 0;
		for (int i = 0; i < ParkingSpace.lisKendaraan.size(); i++) {
			if (ParkingSpace.lisKendaraan.get(i).getVechicleCategory().equals(category))
				count++;
		}
		return count;
	}
	
	public int checkIdProcessBack(String id){
		for (Ticket ticket : ticketBox) {
			if (ticket.getTransactionId().equals(id))
				return 1;
		}
		return -1;
	}
}
