import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yilin on 3/4/2017.
 */
public class Level {
    private int floor;
    private List<ParkingSpot> spots;
    private final int N_SPOTS_PER_ROW = 10;
    private int availableSpots;
    private int totalSpots;

    public Level(int level_num, int n_spots_per_level){
        spots = new ArrayList<>();
        this.floor = level_num;
        totalSpots = n_spots_per_level;
        availableSpots = n_spots_per_level;
        int motoSpots = n_spots_per_level / 4;
        int largeSpots = n_spots_per_level /4;

        for(int i=1; i<=n_spots_per_level; i++){
            VehicleSize size;
            int row = (i - 1) / N_SPOTS_PER_ROW + 1;

            if(i < motoSpots) size = VehicleSize.Motocycle;
            else if(i < largeSpots + motoSpots) size = VehicleSize.Large;
            else size = VehicleSize.Compact;

            spots.add(new ParkingSpot(this, row, i, size));
        }
    }

    public ParkingSpot findAvailableSpot(Vehicle vehicle){
        if(availableSpots < vehicle.spotsNeeded)
                return null;

        int availableSpotsPerRow = 0;
        int lastRow = -1;
        for(int i=0; i<spots.size(); i++){
            ParkingSpot spot = spots.get(i);
            if(spot.getRow() != lastRow){
                availableSpotsPerRow = 0;
            }
            lastRow = spot.getRow();
            if(spot.canFitVehicle(vehicle))
                availableSpotsPerRow++;
            if(availableSpotsPerRow >= vehicle.spotsNeeded) {
                return spots.get(i - vehicle.spotsNeeded + 1);
            }
        }

        return null;
    }

    public boolean parkVehicle(ParkingSpot startingSpot, Vehicle vehicle){
        for(int i=0; i<spots.size(); i++) {
            if(startingSpot == spots.get(i)) {
                for (int j = 0; j < vehicle.spotsNeeded; j++)
                    spots.get(i + j).parkVehicle(vehicle);
            }
        }
        return true;
    }

    public int getAvailableSpots() {
        return availableSpots;
    }

    public void setAvailableSpots(int availableSpots) {
        this.availableSpots = availableSpots;
    }

    public int getFloor() {
        return floor;
    }

    public void printLevelInfo(){
        System.out.println(String.format("=> Level %d : %d available spots", this.floor, this.availableSpots));
        for(ParkingSpot spot : spots){
            spot.printSpotInfo();
        }
    }


}
