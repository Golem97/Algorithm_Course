package parkingProblem;

public class Main {
	public static void main(String[] args) {
		ParkingProblem parking = new ParkingProblem();
		System.out.println("number of cars = " + parking.calcCars());
		System.out.println("DCLL : " + ParkingProblem.parking.toString());
	}

}
