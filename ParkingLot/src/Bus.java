/**
 * Created by Yilin on 3/4/2017.
 */
public class Bus extends Vehicle {
    public Bus(String maker, String licenseNum){
        super(maker, licenseNum);
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large ;
    }

    @Override
    public void print() {
        String status;
        if(this.isParked == true)   status = "It has been parked";
        else    status = "It hasn't been parked";
        System.out.println(String.format("Bus, with licenseNum %s, %s", this.licenseNum, status));
    }
}