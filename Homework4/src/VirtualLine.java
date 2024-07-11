import java.util.ArrayList;

/**
 * The VirtualLine class represents a virtual queue implementation using an ArrayList.
 * It provides methods for adding, removing, and inspecting elements in the queue.
 */

public class VirtualLine extends ArrayList{
    
    ArrayList<Person> currentArrayList = new ArrayList<Person>();

    /**
     * Adds the specified person to the end of the virtual line.
     *
     * @param p The person to be added to the virtual line
     */
    public void enqueue(Person p){
        currentArrayList.add(p);
    }
    /**
     * Removes and returns the person at the front of the virtual line.
     *
     * @return The person at the front of the virtual line
     */
    public Person dequeue(){
        Person temp = currentArrayList.getFirst();
        currentArrayList.remove(currentArrayList.getFirst());
        return temp;
    }
    /**
     * Returns the person at the front of the virtual line without removing it.
     *
     * @return The person at the front of the virtual line
     */
    public Person peek(){
        return currentArrayList.getFirst();
    }
    /**
     * Checks whether the virtual line is empty.
     *
     * @return true if the virtual line is empty, false otherwise
     */
    public boolean isEmpty(){
        return currentArrayList.isEmpty();
    }

     /**
     * Returns the number of persons in the virtual line.
     *
     * @return The number of persons in the virtual line
     */
    public int size(){
        return currentArrayList.size();
    }
}
