/**
 * This generic class is used in the MorseCodeTree classes.
 * The class consists of a reference to the data and a reference to the left and the right child.
 * @author John Mobarry
 * @param <T>
 */
public class TreeNode <T> {

    private T data;
    public TreeNode leftChild;
    public TreeNode rightChild;
    /**
     * Create a new TreeNode with left and right child set to null and data set to the data node
     * @param data
     */
    public TreeNode(T data){
        this.leftChild = null;
        this.rightChild = null;
        this.data = data;
    }
    /**
     * copy constructor for making deep copies of TreeNodes
     * @param node
     */
    public TreeNode(TreeNode<T> node){
        this.data = node.getData();
        this.leftChild = node.getLeftChild();
        this.rightChild = node.getRightChild();
    }
    /**
     * method for confirming if the node in question has a left child
     * useful for debugging
     * @return boolean
     */
    public boolean hasLeft(){
        return this.leftChild!= null;
    }
    /**
     * method for confirming if the node in question has a right child
     * useful for debugging
     * @return boolean
     */
    public boolean hasRight(){
        return this.rightChild!= null;
    }
    /**
     * method to return the data within this TreeNode
     * @return the data of the TreeNode
     */
    public T getData() {
        return data;
    }
    /**
     * Setter method for changing the data of a TreeNode to entered Node
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }
    /**
     * this getter method will return the LeftChild of the node in question
     * @return TreeNode
     */
    public TreeNode getLeftChild() {
        return this.leftChild;
    }
    /**
     * this setter method will set the LeftNode of the Node in the question
     * @param leftChild
     */
    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }
    /**
     * this getter method will return the RightChild of the node in question
     * @return TreeNode
     */
    public TreeNode getRightChild() {
        return this.rightChild;
    }

    /**
     *  this setter method will set the RightNode of the Node in the question
     * @param rightChild
     */
    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}