import java.util.Random;

public class RandomGenerator {
    /**
     * Selects a random ride from the given array of rides.
     *
     * @param rides An array of Ride objects from which a random ride will be selected
     * @return A randomly selected Ride object from the provided array
     */
    public static Ride selectRide(Ride[] rides){
        if(rides.length == 0){
            throw new IllegalArgumentException("Ride array is empty or null.");
        }
        Random rand = new Random();
        int index = rand.nextInt(rides.length);

        return rides[index];
    }
}
