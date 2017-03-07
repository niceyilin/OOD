import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yilin on 3/4/2017.
 */
public abstract class Vehicle {
    protected String licenseNum;
    protected int spotsNeeded;
    protected VehicleSize size;
    protected List<ParkingSpot> spots = new ArrayList<>();
    protected boolean isParked;
    protected String maker;

    public Vehicle(String maker, String licenseNum){
        this.maker = maker;
        this.licenseNum = licenseNum;
        this.isParked = false;
    }

    public void parkInSpot(ParkingSpot spot){
        spots.add(spot);
        isParked = true;
    }

    public void clearSpots(){
        for(ParkingSpot parkingSpot : spots){
            parkingSpot.removeVehicle();
        }
        spots.clear();
        isParked = false;
    }

    public void setLicenseNum(String licenseNum){
        this.licenseNum = licenseNum;
    }

    public String getLicenseNum(){
        return this.licenseNum;
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);

    public abstract void print();
}
