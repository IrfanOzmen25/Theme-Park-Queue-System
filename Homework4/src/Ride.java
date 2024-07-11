import java.util.List;

/**
 * The Ride class represents a ride in a theme park system.
 * It holds information about the duration of the ride, remaining time,
 * the name of the ride, the virtual line associated with the ride,
 * the holding queue associated with the ride, and the list of people currently on the ride.
 */
public class Ride {
    
    private int duration;
    private int timeLeft;
    private String Name;
    private VirtualLine virtualLine;
    private HoldingQueue holdingQueue;
    private List<Person> peopleOnRide;

    /**
     * Constructs a Ride object with default values.
     */
    public Ride(){

    }

    /**
     * Retrieves the duration of the ride.
     *
     * @return The duration of the ride
     */
    //getters
    public int getDuration(){
        return duration;
    }
     /**
     * Retrieves the remaining time for the current ride cycle.
     *
     * @return The remaining time for the current ride cycle
     */
    public int getTimeLeft(){
        return timeLeft;
    }
    /**
     * Retrieves the name of the ride.
     *
     * @return The name of the ride
     */
    public String getName(){
        return Name;
    }
    /**
     * Retrieves the virtual line associated with the ride.
     *
     * @return The virtual line associated with the ride
     */
    public VirtualLine getVirtualLine(){
        return virtualLine;
    }
    /**
     * Retrieves the holding queue associated with the ride.
     *
     * @return The holding queue associated with the ride
     */
    public HoldingQueue getHoldingQueue(){
        return holdingQueue;
    }
    /**
     * Retrieves the list of people currently on the ride.
     *
     * @return The list of people currently on the ride
     */
    public List<Person> getPeopleOnRide(){
        return peopleOnRide;
    }


    //setters
/**
     * Sets the duration of the ride.
     *
     * @param duration The duration of the ride
     */
    public void setDuration(int duration){
        this.duration = duration;
    }
    /**
     * Sets the remaining time for the current ride cycle.
     *
     * @param timeLeft The remaining time for the current ride cycle
     */
    public void setTimeLeft(int timeLeft){
        this.timeLeft = timeLeft;
    }
    /**
     * Sets the name of the ride.
     *
     * @param name The name of the ride
     */
    public void setName(String name){
        this.Name = name;
    }
    /**
     * Sets the virtual line associated with the ride.
     *
     * @param virtualLine The virtual line associated with the ride
     */
    public void setVirtalLine(VirtualLine virtualLine){
        this.virtualLine = virtualLine;
    }
    /**
     * Sets the holding queue associated with the ride.
     *
     * @param holdingQueue The holding queue associated with the ride
     */
    public void setHoldingQueue(HoldingQueue holdingQueue){
        this.holdingQueue = holdingQueue;
    }
    /**
     * Sets the list of people currently on the ride.
     *
     * @param people The list of people currently on the ride
     */
    public void setPeopleOnRide(List<Person> people){
        this.peopleOnRide = people;
    }
    /**
     * Returns a string representation of the Ride object, which is its name.
     *
     * @return A string representation of the Ride object
     */
    public String toString(){
        return Name;
    }
}
