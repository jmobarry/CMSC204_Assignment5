import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * This class is a generic linked binary tree which inherits from the LinkedConverterTreeInterface
 * The class uses an external generic TreeNode class paramaterized as a String: TreeNode<String>
 * This class uses the private member of root. Nodes are added based on their morse code value.
 * @author John Mobarry
 */
public class MorseCodeTree implements LinkedConverterTreeInterface <String>{

    private TreeNode<String> root;
    /**
     * the constructor uses the build tree method to create the morse code binary tree framework
     */
    MorseCodeTree(){
        this.buildTree();
    }
    /**
     * Overridden method from the interface that gets the root
     * @return root
     */
    @Override
    public TreeNode<String> getRoot() {
        return root;
    }
    /**
     * overridden method from the interface used to set the root to a given node
     * @param newNode a TreeNode<T> that will be the new root
     */
    @Override
    public void setRoot(TreeNode<String> newNode) {
    root = newNode;
    }
    /**
     * This method uses the recursive addNode method to insert
     * @param code the code for the new node to be added
     * @param result
     * @return a MorseCodeTree that implements LinkedTreeInterface<String>
     */
    @Override
    public LinkedConverterTreeInterface<String> insert(String code, String result) {
        addNode(getRoot(),code,result);
        return this;
    }
    /**
     * This recursive method adds a Node based by recursively calling through the morse code values
     * by comparing the "-" and "." values.
     * @param root the root of the tree for this particular recursive instance of addNode
     * @param code the code for this particular recursive instance of addNode
     * @param letter the data of the new TreeNode to be added
     * @throws NoSuchElementException
     */
    @Override
    public void addNode(TreeNode<String> root, String code, String letter) throws NoSuchElementException{
        TreeNode<String> temporary = root;

        if(code.length() == 1){
            temporary = new TreeNode(letter);
            if(code.equals(".")){
                root.setLeftChild(temporary);
            }
            else{
                root.setRightChild(temporary);
            }
            return;
        }
        if(code.charAt(0) == '.'){
            addNode(temporary.getLeftChild(), code.substring(1), letter);
        }
        else if(code.charAt(0) == '-'){
            addNode(temporary.getRightChild(),code.substring(1), letter);
        }
        else{
            throw new NoSuchElementException();
        }
    }
    /**
     * Fetch the data in the tree based on the code. This method implements the recursive
     * method fetchNode
     * @param code the code that describes the traversals within the tree
     * @return String
     */
    @Override
    public String fetch(String code) {
        if(code.equals("/")){
            return " ";
        }
        return fetchNode(getRoot(),code);
    }
    /**
     * This is a recursive method that fetches the data of the TreeNode that responds with the
     * code A '.' (dot) means traverse to the left
     * @param root the root of the tree for this particular recursive instance of addNode
     * @param code the code for this particular recursive instance of fetchNode
     * @return
     * @throws NoSuchElementException
     */
    @Override
    public String fetchNode(TreeNode<String> root, String code) throws NoSuchElementException{
        TreeNode<String> temp = root;
        if (code.length() == 0){
            return root.getData();
        }
        if (code.charAt(0) == '.'){
            return fetchNode(temp.getLeftChild(),code.substring(1));
        }
        else if(code.charAt(0)== '-'){
            return fetchNode(temp.getRightChild(),code.substring(1));
        }
        else{
            throw new NoSuchElementException();
        }
    }
    /**
     * this operation is not supported in the MorseCodeTree
     * @param data data of node to be deleted
     * @return null
     * @throws UnsupportedOperationException
     */
    @Override
    public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
        return null;
    }
    /**
     * This operation is not supported in MorseCodeTree
     * @return null
     * @throws UnsupportedOperationException
     */
    @Override
    public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
        return null;
    }
    /**
     * This method builds the MorseCodeTree by inserting the nodes of the tree
     * level based on the code
     */
    @Override
    public void buildTree() {
        setRoot(new TreeNode<String>(""));
        /**
         * this is level one (two characters)
         */
        insert(".","e");
        insert("-","t");
        /**
         * this is level two (three characters)
         */
        insert("..","i");
        insert(".-","a");
        insert("-.","n");
        insert("--","m");
        /**
         * this is level 3 (three characters)
         */
        insert("...","s");
        insert("..-","u");
        insert(".-.","r");
        insert(".--","w");
        insert("-..","d");
        insert("-.-","k");
        insert("--.","g");
        insert("---","o");
        /**
         * this is level four (four characters)
         */
        insert("....","h");
        insert("...-", "v");
        insert("..-.","f");
        insert(".-..","l");
        insert(".--.","p");
        insert(".---","j");
        insert("-...","b");
        insert("-..-","x");
        insert("-.-.","c");
        insert("-.--","y");
        insert("--..","z");
        insert("--.-","q");
    }
    /**
     * This method returns an ArrayList of the items in the linkedTree in inorder Traversal order
     * used for testing to make sure the tree is built correctly
     * Uses the helper method LNRoutputTraversal
     * @return ArrayList<String>
     */
    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> output = new ArrayList<String>();
        LNRoutputTraversal(getRoot(),output);
        return output;
    }
    /**
     * This recursive method is to put the contents of the tree in an ArrayList in order traversal
     * @param root the root of the tree for this particular recursive instance
     * @param list the ArrayList that will hold the contents of the tree in LNR order
     */
    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if (root == null){return;}
        LNRoutputTraversal(root.getLeftChild(),list);
        list.add(root.getData());
        LNRoutputTraversal(root.getRightChild(),list);
    }
}
