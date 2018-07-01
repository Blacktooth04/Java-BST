/*
Russell Lilljedahl
Java tree with Breadth First Search and Depth First Search
*/
package javatree;

import java.util.LinkedList;
import java.util.Queue;

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
    
    // find node
    private boolean findNode(Node current, int value) {
        if (current == null) {
            return false;
        }
        
        if (value == current.value) {
            return true;
        }
        
        /**
         * Just learned about conditional operators.
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
    private Node deleteNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        
        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            int smallestValue = smallest(current.right);
            current.value = smallestValue;
            current.right = deleteNode(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteNode(current.left, value);
            return current;
        }
        current.right = deleteNode(current.right, value);
        return current;
    }
    
    private int smallest(Node root) {
        return root.left == null ? root.value : smallest(root.left);
    }
    
    public void delete (int value) {
        deleteNode(root, value);
    }
    
    // Search
    public void DFSInorder(Node node) {
        if (node != null) {
            DFSInorder(node.left);
            System.out.println(" " + node.value);
            DFSInorder(node.right);
        }
    }
    
    public void DFSPreorder(Node node) {
        if (node != null) {
            System.out.println(" " + node.value);
            DFSInorder(node.left);
            DFSInorder(node.right);
        }    
    }
    
    public void DFSPostorder (Node node) {
        if (node != null) {
            DFSInorder(node.left);
            DFSInorder(node.right);
            System.out.println(" " + node.value);
        }      
    }
    
    public void BFS () {
        if (root == null) {
            return;
        }
        
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.print(" " + node.value);
            
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }
    
    public Node returnRoot() {
        return root;
    }
}
