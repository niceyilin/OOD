import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yilin on 3/4/2017.
 */
public class ParkingLot {
    List<Level> levels;
    public final int N_LEVELS = 3;
    public final int N_SPOTS = 20;

    public ParkingLot(){
        this.levels = new ArrayList<>();
        for(int i=1; i<=N_LEVELS; i++){
            levels.add(new Level(i, N_SPOTS));
        }
    }


    public boolean parkVehicle(Vehicle vehicle){
        System.out.println(String.format("Parking vehicle with license number %s ...", vehicle.getLicenseNum()));
        for(Level level : levels){
            if(level.findAvailableSpot(vehicle) != null){
                level.parkVehicle(level.findAvailableSpot(vehicle), vehicle);
                return true;
            }
        }

        System.out.println(String.format("Failed to park vehicle with license number %s !", vehicle.getLicenseNum()));
        return false;
    }

    public void printLotInfo(){
        System.out.println(String.format("This parking lot has %d levels: ", N_LEVELS));
        for(Level level : levels){
            level.printLevelInfo();
        }
    }

}
