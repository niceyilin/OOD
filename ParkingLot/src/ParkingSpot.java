/**
 * Created by Yilin on 3/4/2017.
 */
public class ParkingSpot {
    private Level level;
    private int row;
    private int num;
    private VehicleSize size;
    private Vehicle vehicle;

    public ParkingSpot(Level level, int row, int num, VehicleSize size){
        this.level = level;
        this.row = row;
        this.num = num;
        this.size = size;
    }

    public boolean isAvailable(){
        return this.vehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle){
        return isAvailable() && vehicle.canFitInSpot(this);
    }

    public VehicleSize getSize(){
        return this.size;
    }

    public int getRow() {
        return row;
    }

    public int getNum() {
        return num;
    }

    public boolean parkVehicle(Vehicle vehicle){
        if(!this.canFitVehicle(vehicle))
            return false;

        System.out.println(String.format("Vehicle %s is parked on level %d, row %d, spot %d !", vehicle.getLicenseNum(), level.getFloor(), this.row, this.num));
        this.vehicle = vehicle;
        vehicle.parkInSpot(this);
        level.setAvailableSpots(level.getAvailableSpots() - 1);
        return true;
    }

    public void removeVehicle(){
        System.out.println(String.format("Vehicle %s is leaving level %d, row %d, spot %d !", vehicle.getLicenseNum(), level.getFloor(), this.row, this.num));
        level.setAvailableSpots(level.getAvailableSpots() + 1);
        vehicle = null;
    }

    public void printSpotInfo(){
        String s;
        if(this.size == VehicleSize.Compact) s = "Compact";
        else if(this.size == VehicleSize.Motocycle) s = "Small";
        else s = "Large";
        System.out.print(String.format("  -> %s Spot, num: %d, row: %d, level: %d, Vehicle: ", s, num, row, level.getFloor()));

        if(!isAvailable())
            vehicle.print();
        else
            System.out.println("empty");
    }

}
