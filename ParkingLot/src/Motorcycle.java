/**
 * Created by Yilin on 3/4/2017.
 */
public class Motorcycle extends Vehicle{
    public Motorcycle(String maker, String licenseNum){
        super(maker, licenseNum);
        spotsNeeded = 1;
        size = VehicleSize.Motocycle;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact || spot.getSize() == VehicleSize.Motocycle;
    }

    @Override
    public void print() {
        String status;
        if(this.isParked == true)   status = "parked";
        else    status = "not parked";
        System.out.println(String.format("Motocycle, with licenseNum %s, %s", this.licenseNum, status));
    }
}
