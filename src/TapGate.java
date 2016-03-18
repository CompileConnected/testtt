
public class TapGate {
	
	ParkingManagement parkirBot = new ParkingManagement();
	static int spotId;
	
	public TapGate() {
		
	}
	
	public void tapIn(Vehicle vehicle){
		ParkingManagement parkingManagement = new ParkingManagement();
		spotId = parkingManagement.assignVehicleToSpot(vehicle);
	}
	
	public void tapOut(String transactionId) throws MyException{
		if (parkirBot.checkIdProcessBack(transactionId) == -1)
			throw new MyException("Id transaction is not found");
	}
}
