import java.util.ArrayList;

/**
 * The HoldingQueue class represents a holding queue implementation, extending the VirtualLine class.
 * It maintains a queue of persons with a specified maximum size.
 */
public class HoldingQueue extends VirtualLine{
    
    private int maxSize;
    
    ArrayList<Person> currentArrayList = new ArrayList<Person>(maxSize);
     /**
     * Adds the specified person to the end of the holding queue.
     * Overrides the enqueue method from the VirtualLine class.
     *
     * @param p The person to be added to the holding queue
     */
    public void enqueue(Person p){
        currentArrayList.add(p);
    }
    /**
     * Removes and returns the person at the front of the holding queue.
     * Overrides the dequeue method from the VirtualLine class.
     *
     * @return The person at the front of the holding queue
     */
    public Person dequeue(){
        Person temp = currentArrayList.getFirst();
        currentArrayList.remove(currentArrayList.getFirst());
        return temp;
    }
    /**
     * Returns the person at the front of the holding queue without removing it.
     * Overrides the peek method from the VirtualLine class.
     *
     * @return The person at the front of the holding queue
     */
    public Person peek(){
        return currentArrayList.getFirst();
    }
    /**
     * Checks whether the holding queue is empty.
     * Overrides the isEmpty method from the VirtualLine class.
     *
     * @return true if the holding queue is empty, false otherwise
     */
    public boolean isEmpty(){
        return currentArrayList.isEmpty();
    }
    /**
     * Returns the person at the front of the holding queue without removing it.
     *
     * @return The person at the front of the holding queue
     */
    public Person front(){
        return currentArrayList.get(0);
    }
    /**
     * Returns the number of persons in the holding queue.
     * Overrides the size method from the VirtualLine class.
     *
     * @return The number of persons in the holding queue
     */
    public int size(){
        return currentArrayList.size();
    }

}
