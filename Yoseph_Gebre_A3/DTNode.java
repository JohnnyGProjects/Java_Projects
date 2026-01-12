public class DTNode{
    public String item;
    public DTNode left;
    public DTNode right;

    /**
     * PURPOSE : Creates a leaf node
     * @param item : String variable to store the question
     */
    public DTNode(String item){
        this.item = item;
    } // end DTNode (leaf) constructor

    /**
     * PURPOSE : Creates an internal node
     * @param item : String variable to store the question
     * @param left : Node that links to the left child
     * @param right : Node that links to the right child
     */
    public DTNode(String item, DTNode left, DTNode right){
        this.item = item;
        this.left = left;
        this.right = right;
    } // end DTNode (internal) constructor

    /**
     * PURPOSE : Checks if a node is a leaf node
     * @param newNode : Accepts a node
     * 
     * @return boolean : returns true if leaf,false if not.
     */
    public boolean isLeaf(DTNode newNode){
        return (newNode.left == null && newNode.right == null);
    } // end isLeaf method
} // end DTNode class
