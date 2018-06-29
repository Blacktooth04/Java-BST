/*
Russell Lilljedahl
Java tree with Breadth First Search and Depth First Search
*/
package javatree;

/**
 * TODO CHANGE TO GENERICS
 */
public class BST {
    
    Node root;
    
    // insert the values into the tree
    private Node insertIntoTree(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        
        if (value < current.value) {
            current.left = insertIntoTree(current.left, value);
        } else if (value > current.value) {
            current.right = insertIntoTree(current.right, value);
        } else {
            return current;
        }
        
        return current;
    }
    
    public void insert(int value) {
        root = insertIntoTree(root, value);
    }
    
    // search for node
    private boolean findNode(Node current, int value) {
        if (current == null) {
            return false;
        }
        
        if (value == current.value) {
            return true;
        }
        
        /**
         * if value < current.value is true, evaluate current.left. 
         * if current.left is true, value is left
         * else right
         * 
         * could also be
         * 
         * if (value < current.value) {
         *     findNode(current.left, value);
         * } else {
         *     findNode(current.right, value);
         * }
        **/
        return value < current.value ? findNode(current.left, value) : findNode(current.right, value);
    }
    
    public boolean hasNode(int value) {
        return findNode(root, value);
    }
    
    // delete node
}
