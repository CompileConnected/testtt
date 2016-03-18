import java.util.ArrayList;
import java.util.Random;


public class ParkingSpace {
	
	static Vehicle[][] garage = new Vehicle[10][10];
	static ArrayList<Vehicle> lisKendaraan = new ArrayList<Vehicle>();
	private int maxBikeVehicle, maxCarVehicle, maxBusVehicle;
	private int maxSpot, spotId;
	
	public ParkingSpace() {
		
	}
	
	public int addToParkingSpace(Vehicle vehicle){
		Random rand = new Random();
		spotId = rand.nextInt(10);
		maxBikeVehicle = rand.nextInt(10);
		maxCarVehicle = rand.nextInt(10);
		maxBusVehicle = rand.nextInt(10);
		garage[0][spotId] = vehicle;
		lisKendaraan.add(vehicle);
		return spotId;
	}
	
}
