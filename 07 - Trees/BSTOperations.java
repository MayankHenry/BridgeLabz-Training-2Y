import java.util.*;

class BSTOperations {
    int data;
    BSTOperations left, right;

    BSTOperations(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    static BSTOperations insert(BSTOperations root, int key) {
        if(root == null) return new BSTOperations(key);
        if(key < root.data) root.left = insert(root.left, key);
        else if(key > root.data) root.right = insert(root.right, key);
        return root;
    }

    static int findMin(BSTOperations node) {
        while(node.left != null) node = node.left;
        return node.data;
    }

    static BSTOperations delete(BSTOperations root, int key) {
        if(root == null) return null;
        if(key < root.data) root.left = delete(root.left, key);
        else if(key > root.data) root.right = delete(root.right, key);
        else {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            int successor = findMin(root.right);
            root.data = successor;
            root.right = delete(root.right, successor);
        }
        return root;
    }

    static void inorder(BSTOperations node, List<Integer> result) {
        if(node == null) return;
        inorder(node.left, result);
        result.add(node.data);
        inorder(node.right, result);
    }

    static void rangeSearch(BSTOperations node, int low, int high, List<Integer> result) {
        if(node == null) return;
        if(node.data > low) rangeSearch(node.left, low, high, result);
        if(node.data >= low && node.data <= high) result.add(node.data);
        if(node.data < high) rangeSearch(node.right, low, high, result);
    }

    static void printTree(BSTOperations node, String prefix, boolean isLeft) {
        if(node == null) return;
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.data);
        printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
        printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
    }

    public static void main(String[] args) {
        int[] rollNumbers = {15, 10, 20, 8, 12, 17, 25};
        BSTOperations root = null;
        for(int roll : rollNumbers) {
            root = insert(root, roll);
        }

        System.out.println("Original BST:");
        printTree(root, "", false);

        System.out.println("\na) Deleting node 10 (two children):");
        System.out.println("   Step 1: Node 10 has two children (8 and 12)");
        System.out.println("   Step 2: Find inorder successor of 10 -> 12 (smallest in right subtree)");
        System.out.println("   Step 3: Replace 10's value with 12");
        System.out.println("   Step 4: Delete the original 12 from right subtree");
        root = delete(root, 10);
        System.out.println("   Tree after deleting 10:");
        printTree(root, "   ", false);

        System.out.println("\nb) Inserting roll number 14:");
        System.out.println("   Step 1: Compare 14 with 15 -> go left");
        System.out.println("   Step 2: Compare 14 with 12 -> go right");
        System.out.println("   Step 3: 12's right is null, insert 14 here");
        root = insert(root, 14);
        System.out.println("   Tree after inserting 14:");
        printTree(root, "   ", false);

        System.out.println("\nc) Inserting roll number 9:");
        System.out.println("   Step 1: Compare 9 with 15 -> go left");
        System.out.println("   Step 2: Compare 9 with 12 -> go left");
        System.out.println("   Step 3: Compare 9 with 8 -> go right");
        System.out.println("   Step 4: 8's right is null, insert 9 here");
        root = insert(root, 9);
        System.out.println("   Tree after inserting 9:");
        printTree(root, "   ", false);

        List<Integer> rangeResult = new ArrayList<>();
        rangeSearch(root, 10, 20, rangeResult);
        System.out.println("\nd) Students with roll numbers between 10 and 20: " + rangeResult);
        System.out.println("   Inorder traversal with range pruning is most efficient because");
        System.out.println("   it skips subtrees that cannot contain values in the range.");

        System.out.println("\ne) Time Complexity for searching roll number 25:");
        System.out.println("   Best Case (balanced BST): O(log n) = O(log 7) ~ O(3)");
        System.out.println("   Worst Case (skewed BST): O(n) = O(7)");
    }
}
