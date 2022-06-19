import org.junit.jupiter.api.*;
import java.io.*;

public class PriorityQueueTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setOut() {
        System.out.println(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("Testing the insert() method by deleting value from delete() method")
    public void testInsertWithDeletion() {
        // Assign
        PriorityQueue priorityQueue = new PriorityQueue(10);
        // act
        priorityQueue.insert(new Node(1));
        Node n = priorityQueue.delete();
        int actual = n.priority;
        // Assert
        Assertions.assertEquals(1, actual);
    }

}
