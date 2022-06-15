import java.util.Arrays;

/**
 * {@index PriorityQueue Implements a Priority Queue using an arrary of nodes,}
 * sorted with minheap
 *
 * {@author Luke Ponga}
 */
public class PriorityQueue {

    // Constructor //
    Node[] minHeap;

    int next = 0;

    public PriorityQueue(int capacity) {
        minHeap = new Node[capacity + 1];
        next = 1;
    }

    // Methods //

    /**
     * method insert
     *
     * {@param n}, the node into priority queue
     */
    public void insert(Node n) {
        minHeap[next] = n;
        upheap(next);
        next++;
    }

    /**
     * method delete
     *
     * renoves highest priority node
     */
    public Node delete() {
        // set root to 1
        int root = 1;
        int lastLeft = next - 1;
        // Check if heap is empty
        if (next == 1) {
            return peek();
        }
        // If root is last leaf delete it
        if (root == lastLeft) {
            minHeap[lastLeft].minHeap = 0;
            next--;
        } else {
            swap(root, lastLeft);
            minHeap[lastLeft].minHeap = 0;
            next--;
        }

        downHeap();
        return peek();
    }

    private Node peek() {
        return minHeap[1];
    }

    // Helper methods //

    /**
     * method swap
     * swaps pos1 and pos2 without overwritting them
     * by creating temp variable
     * 
     * @param pos1
     * @param pos2
     */
    private void swap(int pos1, int pos2) {
        // Store value of position one
        Node temp = minHeap[pos1];

        // Set value of position one to equal position 2
        minHeap[pos1] = minHeap[pos2];

        // Set value of position two to equal temp
        minHeap[pos2] = temp;
    }

    /**
     * method upheap
     * {@summary Sorts priority queue - minheap }
     *
     * @param pos
     */
    private void upheap(int pos) {
        // Set child to current node
        int child = pos;

        // While child node is greater than 1
        while (child > 1) {
            int parent = child / 2;

            // If childs value is less than parents value
            if (minHeap[child].minHeap < minHeap[parent].minHeap) {
                // Swap child and parent values,
                swap(child, parent);
            }
            child = parent;
        }
    }

    /**
     * method downHeap
     * 
     * @return
     *
     */
    private void downHeap() {
        int smallest = -1;
        int parent = 1;
        while (parent < next) {
            int left = parent * 2;
            int right = parent * 2 + 1;

            if (left < next && minHeap[left].minHeap < minHeap[parent].minHeap) {
                smallest = left;
            }

            if (right < next && minHeap[right].minHeap < minHeap[smallest].minHeap) {
                smallest = right;
            }

            if (parent != smallest) {
                swap(smallest, parent);
                parent = smallest;
            } else {
                // exit loop
                break;
            }

        }
    }

    /**
     * method dump
     *
     * prints the minheap the console
     */
    public void dump() {
        System.out.println("Priority: " + Arrays.toString(minHeap));
    }
}
