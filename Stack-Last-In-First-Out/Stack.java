/**
 * Stack class
 * 
 * Stack is a linkedlist of strings.
 * The Stack class holds the head of the
 * linkedlist and a set of stack operations
 * 
 * @author Luke Ponga
 */
public class Stack {

                // The head of the stack
                private Node head;

                /**
                 * Constructor
                */
                public Stack() {
                        head = null;
                }

                /**
                 * push(String x)
                 * pushes a new node onto the top of the stack
                 * @param x, the string being inserted
                */
                public void push(String x) {
                        Node newNode = new Node(x);
                        newNode.setValue(x);
                        newNode.setNext(head);
                        head = newNode;
                }

                /**
                 * pop()
                 * pops the head node out of the stack.
                 * @return 
                */
                public String pop() {

                       // pop the top node out of the stack
                        String result = head.getValue();

                        // point head to next node
                        head = head.getNext();
                        return result;
                }
               
                /**
                 * peek()
                 * looks at the top value in the stack
                 * @return 
                */
                public String peek() {
                        return head.getValue();
                }                      
                        
                /**
                 * lengthR 
                 * traverse over all the elements in stack and add 1 to count 
                 * @param current
                 * @return
                 */
                private int lengthR(Node current) {
                        // check to see if this node is null
                        if (current == null) {
                                return 0;
                        }
                        
                        // call this function with the next node as the parameter
                        int count = lengthR(current.getNext());
                        return  count + 1;
                }
                                
                 /**
                  * length
                 * Calling the lengthR method
                 * @return
                 */
                public int length(){
                         return lengthR(head);
                }

                /**
                 * isEmpty()
                 * If Node head is empty
                 * @return true else false
                 */
                public boolean isEmpty() {
                        if (head == null) {
                                 return true;
                        }
                         return false;
                }

                /**
                 * dump()
                 * calling from the dumpR method
                */
                public void dump() {
                        dumpR(head);
                }

                /**
                 * dumpR() Recursive method 
                 * prints out the strings in stack to the console
                 * @param currNode
                 */
                private void dumpR(Node currNode) {
                                if (currNode == null) {
                                        return;
                                } 
                                // output the value of current node
                                System.out.println(currNode.getValue());
                                
                                // go to the next node
                                dumpR(currNode.getNext());
                        }

}
