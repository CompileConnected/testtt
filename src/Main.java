import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	Scanner scan = new Scanner(System.in);
	String nomorPolisi;
	TapGate tapGate = new TapGate();
	ParkingManagement parkirBot = new ParkingManagement();
	int countMobil = 0, countMotor = 0, countBus = 0;
	
	public Main() {
		int chosenMenu;
		do
		{
			System.out.println("Parking System");
			System.out.println("1. Check Slot");
			System.out.println("2. Tap In");
			System.out.println("3. Tap Out");
			System.out.println("4. Detail");
			System.out.println("5. Exit");
			System.out.println(">>");
			chosenMenu = scan.nextInt();scan.nextLine();
			switch (chosenMenu) {
			case 1:
				checkSlot();
				break;
			case 2:
				tapInProcess();
				break;
			case 3:
				tapOutProcess();
				break;
			case 4:
				break;
			}
		}while(chosenMenu != 5);
	}
	
	public void tapOutProcess(){
		try {
			String inputedTransactionId;
			System.out.println("Insert Your transaction Id");
			inputedTransactionId = scan.nextLine();
			tapGate.tapOut(inputedTransactionId);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void checkSlot(){
		System.out.println("Bike Total at our Vallet = " + parkirBot.getCount("motor"));
		System.out.println("Car Total at Our Vallet = " + parkirBot.getCount("mobil"));
		System.out.println("Bus Total at our Vallet = " + parkirBot.getCount("bus"));
		System.out.println(parkirBot.getCount("bus"));
	}
	
	public void tapInProcess(){
		int chosenVehicle;
		
		System.out.println("Choose Vehicle");
		System.out.println("1. MotorCycle");
		System.out.println("2. Car");
		System.out.println("3. Bus");
		System.out.println(">>");
		chosenVehicle = scan.nextInt();scan.nextLine();
		switch (chosenVehicle) {
		case 1:
			choseVehicleProcess("motor");
			break;
		case 2:
			choseVehicleProcess("mobil");
			break;
		case 3:
			choseVehicleProcess("bus");
			break;
		}
	}
	
	public void choseVehicleProcess(String category){
		
		
		Vehicle vehicle = null;
		System.out.println("Input your vehicle's police number : ");
		nomorPolisi = scan.nextLine();
		
		if (category.equals("motor")){
			vehicle = new Motor(countMotor, nomorPolisi);
			tapGate.tapIn(vehicle);
			System.out.println(TapGate.spotId);
			countMotor++;
		}else if (category.equals("mobil")){
			vehicle = new Mobil(countMobil, nomorPolisi);
			tapGate.tapIn(vehicle);
			System.out.println(TapGate.spotId);
			countMobil++;
		}else if (category.equals("bus")){
			vehicle = new Bus(countBus, nomorPolisi);
			tapGate.tapIn(vehicle);
			System.out.println(TapGate.spotId);
			countMobil++;
		}
		
		Ticket ticket = parkirBot.createTicket(vehicle);
		System.out.println("Your Ticket");
		System.out.println("-------------");
		System.out.println("Vehicle's Police number : " + ticket.getPoliceNumber());
		System.out.println("Vehicle Category : " + ticket.getVehicleType());
		System.out.println("Transaction ID : " + ticket.getTransactionId());
		System.out.println("Price : " + ticket.getPrice());
		System.out.println("Arrival Date : " + ticket.getDate());
		System.out.println("Arrival Time : " + ticket.getComingTime());
		scan.nextLine();
	}

	public static void main(String[] args) {
		new  Main();
	}

}
