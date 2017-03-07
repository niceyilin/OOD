/**
 * Created by Yilin on 3/6/2017.
 */

public class ParkingLotApp {
    public static void main(String [] args){
        System.out.println(" *** Welcome to Yilin's Parking Lot *** ");

        // create parking lot object
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.printLotInfo();

        // create vehicles
        Car car1 = new Car("Jeep", "9DVV");
        Car car2 = new Car("VW", "XY123");
        Motorcycle moto1 = new Motorcycle("Honda", "1S34G");
        Bus bus1 = new Bus("School Bus", "987GG");

        // park cars
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(moto1);
        parkingLot.parkVehicle(bus1);
        //car1.clearSpots();
        parkingLot.printLotInfo();



    }
}
