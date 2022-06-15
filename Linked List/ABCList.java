public class ABCList {
    private ABCNode head;

    private class ABCNode {
        char value;
        ABCNode next;

        // Constructor
        public ABCNode(char c) {
            this.value = c;
            this.next = null;
        }

    }

    public ABCList() {
        head = null;
    }

    // Public Methods
    /* adds new node to the top of the list */
    public void add(char c) {
        ABCNode newNode = new ABCNode(c);
        newNode.next = head;
        head = newNode;
    }

    /*
     * returns true if the linked list contains a node with a value,
     * else false
     */
    public boolean has(char c) {
        ABCNode current = head;
        while (current != null) { // while node is not empty
            if (current.value == c) {
                return true; // if string is found return true
            }
            current = current.next; // traverse to the next node in the linked list
        }
        return false; // if not found return false
    }

    /*
     * finds the first node node whose value is c & removes that node without
     * affecting the order of remaining nodes in list
     */
    public void remove(char c) {
        // if list is empty, return
        if (isEmpty() && !has(c)) {
            return;
        }
        // Remove head
        if (head.value == c) {
            head = head.next;
        }
        // Remove middle
        ABCNode previous = head; // start at the top of the list
        ABCNode current = head.next;
        while (current != null) { // opens a loop to iterate through the rest of the list
            if (current.value == c) {
                ABCNode toRemove = current;
                previous.next = toRemove.next;
                current = toRemove.next;
            } else {
                previous = previous.next;
                current = current.next;
            }
        }
    }

    /*
     * count of the number of values in the linked list
     * returns them as an integer
     */
    public int length() {
        ABCNode current = head;
        int counter = 0; // initialises a variable to keep count
        while (current != null) { // opens a loop to iterate through the list
            counter++; // adds 1 to count
            current = current.next; // move to next node
        }
        // return the count
        return counter;
    }

    /* returns true if length() is 0 false otherwise */
    public boolean isEmpty() {
        if (length() == 0) {
            return true;
        }
        return false;
    }

    /* prints out each string in the list */
    public void dump() {
        ABCNode current = head;
        while (current != null) {
            // /n prints each value on a line by itself
            System.out.print(current.value + "\n");
            current = current.next;
        }
        System.out.println();
    }
}
