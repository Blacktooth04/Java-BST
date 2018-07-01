/*
Russell Lilljedahl
Java tree with Breadth First Search and Depth First Search
*/
package javatree;

import java.util.Random;

/**
 *
 * @author russell3233
 */
public class JavaTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int count = 50;
        int[] array = new int[count];
        int value;
        BST bst = new BST();
        
        // generate random numbers
        for (int i = 0; i < count; i++) {
            Random rand = new Random();
            value = rand.nextInt(1000); // seems large enough
            array[i] = value;
            bst.insert(value);
            System.out.print("Inserted: " + array[i] + ", ");
        }        
        System.out.println("\nArray generated.");
               
        // test the find methods
        System.out.println("Array at 7 is: " + array[7]);
        System.out.println("BST has node: " + bst.hasNode(array[7]));
        
        // test the DFS Inorder
        //bst.DFSInorder(node);
        
        // test the delete method
        System.out.println("Removing at 7");
        bst.delete(array[7]);
    }
    
}
