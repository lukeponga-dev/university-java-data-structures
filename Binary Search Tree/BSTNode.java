
public class BSTNode {
    private String value;
    private BSTNode left;
    private BSTNode right;

    public BSTNode(String s) {
        setValue(s);
        setLeft(left);
        setRight(right);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
         this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public static String getOutput() {
            String output = " " + " ";
            return output;
    }
}
