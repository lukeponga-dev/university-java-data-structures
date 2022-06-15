/**
 * Parser class
 * 
 * Parser class has a method which uses stack class,
 * to determine if a string is well formated with regards to its parentheses
 * and a private method getString() which,
 * generates random strings with random parentheses. to debug the check() method
 * @author Luke Ponga
 */
public class Parser {

        /**
         * Check(str) if parentheses are balanced
         * @return true otherwise false
         */
        public boolean check(String str) {

                // Initilize variables
                Stack stack = new Stack();
                int scount = 0;

                // Traverse the characters in String str
                for (char ch : str.toCharArray()) {
                        if (ch == '(') {
                                
                                // push the element in the stack
                                stack.push(str);
                        } else if (ch == ')' && !stack.isEmpty()) {
                                stack.pop();
                        } else if (ch == ')' && scount > 0) {
                                scount--;
                        } else if (ch == ')') {
                                return false;
                        } else {
                                scount++;
                                if (!stack.isEmpty()) {
                                        stack.pop();
                                        scount++;
                                }
                        }
                }

                // Check empty stack
                return stack.isEmpty();
        }

        /**
         * getString
         * generate random parentheses strings
         * @return generated strings
        */
        public String getString() {
                        String str = "()";
                        int sLength = 10;
                        
                        // create string buffer size of str
                        StringBuilder sBuilder = new StringBuilder(sLength);

                        // generate a random number between 0 to str length
                        for (int i = 0; i < 10; i++) {
                                        int index = (int) (str.length() * Math.random());

                                        // add character one by one in end of sbuilder
                                        sBuilder.append(str.charAt(index));

                        }
                        return sBuilder.toString();
        }
}
