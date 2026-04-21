import java.util.*;

class BSTConstruction {
    int data;
    BSTConstruction left, right;

    BSTConstruction(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    static BSTConstruction insert(BSTConstruction root, int key) {
        if(root == null) return new BSTConstruction(key);
        if(key < root.data) root.left = insert(root.left, key);
        else if(key > root.data) root.right = insert(root.right, key);
        return root;
    }

    static void inorder(BSTConstruction node, List<Integer> result) {
        if(node == null) return;
        inorder(node.left, result);
        result.add(node.data);
        inorder(node.right, result);
    }

    static boolean search(BSTConstruction root, int key, List<Integer> comparisons) {
        if(root == null) return false;
        comparisons.add(root.data);
        if(key == root.data) return true;
        if(key < root.data) return search(root.left, key, comparisons);
        return search(root.right, key, comparisons);
    }

    static boolean isValidBST(BSTConstruction node, int min, int max) {
        if(node == null) return true;
        if(node.data <= min || node.data >= max) return false;
        return isValidBST(node.left, min, node.data) && isValidBST(node.right, node.data, max);
    }

    static int height(BSTConstruction node) {
        if(node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    static void printTree(BSTConstruction node, String prefix, boolean isLeft) {
        if(node == null) return;
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.data);
        printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
        printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
    }

    public static void main(String[] args) {
        int[] isbns = {50, 30, 70, 20, 40, 60, 80, 10, 25};
        BSTConstruction root = null;
        for(int isbn : isbns) {
            root = insert(root, isbn);
        }

        System.out.println("a) BST after all insertions:");
        printTree(root, "", false);

        List<Integer> comparisons = new ArrayList<>();
        search(root, 25, comparisons);
        System.out.println("\nb) Comparisons made when searching for ISBN 25: " + comparisons);

        List<Integer> sorted = new ArrayList<>();
        inorder(root, sorted);
        System.out.println("\nc) Inorder Traversal (should be sorted): " + sorted);

        BSTConstruction invalidRoot = new BSTConstruction(50);
        invalidRoot.left = new BSTConstruction(30);
        invalidRoot.right = new BSTConstruction(70);
        invalidRoot.left.left = new BSTConstruction(20);
        invalidRoot.left.right = new BSTConstruction(65);
        invalidRoot.right.left = new BSTConstruction(60);
        invalidRoot.right.right = new BSTConstruction(80);

        boolean valid = isValidBST(invalidRoot, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("\nd) Is the given tree a valid BST? " + valid);
        System.out.println("   Reason: Node 65 is in the left subtree of 50 but 65 > 50,");
        System.out.println("   which violates the BST property.");

        System.out.println("\ne) Height of balanced BST with 9 elements: " + height(root));
        System.out.println("   Height of completely skewed BST with 9 elements: 8");
        System.out.println("   A skewed BST degrades to a linked list, making operations O(n)");
        System.out.println("   instead of O(log n) in a balanced tree.");
    }
}
