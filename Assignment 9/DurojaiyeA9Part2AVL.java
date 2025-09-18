// Name: Emmanuel Durojaiye
// Class: CS 3305/ W04
// Term: Fall 2024
// Instructor: Carla McManus
// Assignment: 9-Part-2-AVL



public class DurojaiyeA9Part2AVL{
    public static void main(String[] args){
        // Create an instance of AVLTree
        AVLTree<Integer> avlTree = new AVLTree<>();

        // Test insertion
        System.out.println("Inserting elements into the AVL Tree:");
        int[] elements = {8, 26, 49, 14, 1, 20, 35};
        for(int element : elements){
            avlTree.insert(element);
            System.out.println("Inserted " + element);
        }
        System.out.println();
        print(avlTree);

        System.out.println();
        avlTree.delete(1); // Deleting the number 1
        avlTree.delete(14); // Deleting the number 14
        avlTree.delete(8); // Deleting the number 8
        System.out.println("\nAfter deleting 1, 14, 8: ");
        print(avlTree);
        System.out.println();

        avlTree.insert(2); // Adding the number 2
        avlTree.insert(15); // Adding the number 15
        avlTree.insert(9); // Adding the number 9
        System.out.println("\nAfter adding 2, 15, 9: ");
        print(avlTree);
        System.out.println();


    }


    // Prints all the traversal for the tree and how many numbers there are
    public static void print(BST tree){
        // Test in-order traversal
        System.out.print("Inorder traversal: " );
        tree.inorder();

        // Test post-order traversal
        System.out.print("\nPostorder traversal: ");
        tree.postorder();

        // Test pre-order traversal
        System.out.print("\nPreorder traversal: ");
        tree.preorder();

        // Prints how many numbers are in the tree
        System.out.print("\nThe size of the tree is " + tree.getSize());
    }
}
