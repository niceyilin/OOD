/**
 * Created by Yilin on 3/4/2017.
 */
public class Car extends Vehicle {
    public Car(String maker, String licenseNum){
        super(maker, licenseNum);
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact ;
    }

    @Override
    public void print() {
        String status;
        if(this.isParked == true)   status = "It has been parked";
        else    status = "It hasn't been parked";
        System.out.println(String.format("Car, with licenseNum %s, %s", this.licenseNum, status));
    }
}

