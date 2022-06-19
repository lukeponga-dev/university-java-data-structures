/**
 * {@index }
 * priorityQueue Implements a priority Queue using an arrary of nodes,
 * sorted with minheap
 *
 * {@author Luke Ponga}
 */
public class PriorityQueue {

    // Min heap stored as an array of nodes
    private Node[] minHeap;
    // pointer to the next position
    private int size;

    /**
     * Initialises a new priority queue, creates the min heap, and sets size to 0
     *
     * @param capacity Max capacity to be given to the min heap
     */
    public PriorityQueue(int capacity) {
        if (capacity < 1) {
            capacity = 1;
        }

        minHeap = new Node[capacity];
        size = 0;
    }

    // Methods //

    /**
     * method insert
     *
     * {@param n}, the node into priority queue
     */
    public void insert(Node n) {
        if (n == null) {
            return;
        }

        minHeap[size] = n;
        size++;
        upheap(size - 1);

        if (size == minHeap.length) {
            increaseMaxSize();
        }
    }

    /**
     * Doubles the capacity of minHeap
     */
    private void increaseMaxSize() {
        Node[] newheap = new Node[minHeap.length * 2];
        System.arraycopy(minHeap, 0, newheap, 0, minHeap.length);
        minHeap = newheap;
    }

    /**
     * method delete
     *
     * renoves highest priority node
     */
    public Node delete() {
        if (size == 0) {
            return null;
        }
        Node n = minHeap[0];
        minHeap[0] = minHeap[size - 1];
        minHeap[size - 1] = null;
        size--;
        downHeap(0);
        return n;
        // // set root to 1
        // int root = 1;
        // int lastLeft = size - 1;
        // // Check if heap is empty
        // if (size == 1) {
        // return peek();
        // }
        // // If root is last leaf delete it
        // if (root == lastLeft) {
        // minHeap[lastLeft].minHeap = 0;
        // size--;
        // } else {
        // swap(root, lastLeft);
        // minHeap[lastLeft].minHeap = 0;
        // size--;
        // }

        // downHeap();
        // return peek();
    }

    // Helper methods //

    /**
     * method upheap
     * {@summary Sorts priority queue - minheap }
     *
     * @param pos
     */
    private void upheap(int pos) {
        // Set child to current node
        if (pos > 0 && minHeap[pos].priority < minHeap[(pos - 1) / 2].priority) {
            Node temp = minHeap[(pos - 1) / 2];
            minHeap[(pos - 1) / 2] = minHeap[pos];
            minHeap[pos] = temp;

            upheap((pos - 1) / 2);
        }
        // // While child node is greater than 1
        // while (child > 1) {
        // int parent = child / 2;

        // // If childs value is less than parents value
        // if (minHeap[child].minHeap < minHeap[parent].minHeap) {
        // // Swap child and parent values,
        // swap(child, parent);
        // }
        // child = parent;
        // }
    }

    /**
     * method downHeap
     *
     * @return
     *
     */
    private void downHeap(int i) {
        int smallest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left < size && minHeap[left].priority < minHeap[smallest].priority) {
            smallest = left;
        }
        if (right < size && minHeap[right].priority < minHeap[smallest].priority) {
            smallest = right;
        }
        if (smallest != i) {
            Node temp = minHeap[i];
            minHeap[i] = minHeap[smallest];
            minHeap[smallest] = temp;
            downHeap(smallest);
        }
    }

    /**
     * method dump
     *
     * prints the minheap the console
     */
    public void dump() {
        for (int i = 0; i < size; i++) {
            System.out.println(
                    "Root: " +
                            minHeap[i] +
                            "; left: " +
                            leftChild(i) +
                            "; right: " +
                            rightChild(i));
        }
    }

    /**
     * Gets the left child of the node at a given position, unless left child
     * would be at a position outside minheap, in which case returns null
     *
     * @param i Position of the parent node
     * @return The left child of a given node
     */
    private Node leftChild(int i) {
        if (i * 2 + 1 >= size) {
            return null;
        } else {
            return minHeap[i * 2 + 1];
        }
    }

    /**
     * Gets the left child of the node at a given position, unless left child
     * would be at a position outside minheap, in which case returns null
     *
     * @param i Position of the parent node
     * @return The right child of a given node
     */
    private Node rightChild(int i) {
        if (i * 2 + 2 >= size) {
            return null;
        } else {
            return minHeap[i * 2 + 2];
        }
    }
}
