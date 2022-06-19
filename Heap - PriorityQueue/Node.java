public class Node {

    // variables
    int priority;

    /**
     * Constructor
     * 
     * @param capacity
     */
    public Node(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {

        return "Priority:" + priority;
    }
}