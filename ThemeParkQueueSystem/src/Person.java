import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * The Person class represents an individual in a theme park system.
 * Each person has a unique identification number, can join multiple ride lines,
 * and has a membership status based on the maximum number of lines they can join.
 */

 
public class Person {
    
    private int number;
    private int maxLines;
    private List<Ride> lines;
    private Status Status;
    private String membership;

    /**
     * Constructs a Person object with the specified identification number.
     * The list of ride lines is initialized to an empty ArrayList.
     *
     * @param number The unique identification number of the person
     */
    public Person(int number){
        this.number = number;
        this.lines = new ArrayList<Ride>();
    }

    /**
     * Retrieves the identification number of the person.
     *
     * @return The identification number of the person
     */
    public int getNumber(){
        return number;
    }
    /**
     * Retrieves the membership of person.
     *
     * @return The membership of person.
     */
    public String getMembership(){
        return this.membership;
    }

     /**
     * Retrieves the maximum number of ride lines the person can join.
     *
     * @return The maximum number of ride lines the person can join
     */
    public int getMaxLines(){
        return maxLines;
    }
    /**
     * Retrieves the list of ride lines the person is currently in.
     *
     * @return The list of ride lines the person is currently in
     */
    public List<Ride> getLines(){
        return lines;
    }
    /**
     * Retrieves the membership status of the person.
     *
     * @return The membership status of the person
     */
    public Status getStatus(){
        return Status;
    }
    /**
     * Adds the specified ride to the list of ride lines the person is currently in.
     *
     * @param ride The ride to be added to the person's list of ride lines
     */
    public void addToLine(Ride a){
        lines.add(a);
    }

/**
     * Sets the identification number of the person.
     *
     * @param number The new identification number of the person
     */

    public void setNumber(int number){
        this.number = number;
    }
    /**
     * Sets the membership for each user.
     *
     * @param membership The membership designation for users.
     */
    public void setMembership(String membership){
        this.membership = membership;
    }
     /**
     * Sets the maximum number of ride lines the person can join.
     *
     * @param maxLines The new maximum number of ride lines the person can join
     */
    public void setMaxlines(int maxLines){
        this.maxLines = maxLines;
    }

    /**
     * Sets the list of ride lines the person is currently in.
     *
     * @param lines The new list of ride lines the person is currently in
     */
    public void setLines(List<Ride> lines){
        this.lines = lines;
    }
    /**
     * Sets the membership status of the person.
     *
     * @param status The new membership status of the person
     */
    public void setStatus(Status status){
        this.Status = status;
    }
 /**
     * Returns a string representation of the Person object, including their membership status and identification number.
     *
     * @return A string representation of the Person object
     */
    public String toString(){
        if(maxLines==1){
            membership="Regular";
        }if(maxLines==2){
            membership="Silver";
        }if(maxLines==3){
            membership="Gold";
        }

        return membership+" "+number;
    }
    
    

}
