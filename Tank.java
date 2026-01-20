import java.util.ArrayList;
public class Tank{
    private ArrayList<Fish> fishies;
    private int temp;

    public Tank(int t){
        this.temp = t;
        fishies = new ArrayList<Fish>();
    }
    
    /**
     * Returns a list of all fish in this tank. If there are
     * no fish in this tank, returns an empty list.
     * @return a list of all fish in the tank or an empty list
     */
    public ArrayList<Fish> getFish(){
        return fishies;
    }

    /**
     * @return the temperature of this tank
     */
    public int temp(){
        return temp;
    }

    /**
     * Adds the specified fish to this tank
     * @param fishy the fish to add
     */
    public void addFish(Fish fishy){
        fishies.add(fishy);
    }



    // public boolean onlyFriends(Fish fish){
    //     for (Fish fishies : tank)
    // }
    public String toString(){
        String text = "temp: "+this.temp;
        for (Fish fish : fishies){
            text+= fish.getType()+", ";
        }
        return text;
    }
    // There may be variables, constructors, and methods that are not shown.
}
