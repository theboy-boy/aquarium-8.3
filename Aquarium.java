import java.util.*;

public class Aquarium{
    // The list of all tanks in the aquarium; guaranteed never to be null
    private ArrayList<Tank> tanks;

    public Aquarium(){
        this.tanks = new ArrayList<Tank>();
    }


    public ArrayList<Tank> getTanks(){
        return tanks;
    }
    /**
     * Returns a tank in this aquarium with a temperature fishy can tolerate and
     * that does not contain a fish that is not compatible with fishy. Returns
     * null if there is no such tank in this aquarium.
     * Postcondition: The state of this aquarium is unchanged.
     * @param fishy the fish to be checked
     * @return a suitable tank for fishy or null if no such tank exists
     */
    public Tank findTank(Fish fishy){
        /* to be implemented in part (a) */
        for (Tank tank : tanks){
            if (fishy.minTemp() <tank.temp() && fishy.maxTemp()>tank.temp()){
                boolean compatable = true;
                for (Fish fishies : tank.getFish()){
                    if (fishy.isCompatible(fishies)){
                        compatable=false;
                        break;
                    }
                }
                if (compatable){
                    return tank;
                }
            }
        }
        return null;
    }

    /**
     * Adds each fish in fishes to a suitable tank in this aquarium if such a
     * tank exists. Each fish should be added to at most 1 tank.
     * @param fishes the list of fish to add
     * @return a list of the fish in fishes that could not be added
     */
    public ArrayList<Fish> addFish(ArrayList<Fish> fishes){
        ArrayList<Fish> notAdded = new ArrayList<Fish>();
        for (Fish fish : fishes){
            Tank suitableTank = findTank(fish);
            if (suitableTank == null){
                notAdded.add(fish);
            }else{
                suitableTank.addFish(fish);
            }
        }
        return notAdded;
    }

    /**
     * Adds fishTank to this aquarium if a suitable position can be found. The
     * temperature of fishTank can be no more than 5 degrees different (lower or
     * higher) than each of any adjacent tanks.
     * Postcondition: the order of the other tanks in the aquarium relative to each other is not changed
     * @param fishTank the tank to add
     * @return true if fishTank was added, false otherwise
     */
    public boolean addTank(Fish fish){

        if (tanks.isEmpty()){
            tanks.add(new Tank((fish.minTemp()+fish.maxTemp())/2));
            return true;
        }
        Tank fishTank = new Tank((fish.minTemp()+fish.maxTemp())/2);
        if (Math.abs(fishTank.temp()-tanks.get(0).temp())<=5){
            tanks.add(0, fishTank);
            return true;
        }
        for (int i = 1; i<tanks.size(); i++){
            int tempDifLower = Math.abs(fishTank.temp()-tanks.get(i-1).temp());
            int tempDifUpper = Math.abs(fishTank.temp()-tanks.get(i).temp());
            if ((Math.abs(fishTank.temp()-tempDifLower)<=5)&&(Math.abs(fishTank.temp()-tempDifUpper))<=5){
                tanks.add(i, fishTank);
                return true;
        }
        }
        if (Math.abs(fishTank.temp()-tanks.get(tanks.size()-1).temp())<=5){
            tanks.add(tanks.size()-1, fishTank);
            return true;
        }
        return false;
    }
}