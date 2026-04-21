import java.util.*;

class TraversalApplication {
    String name;
    TraversalApplication left, right;

    TraversalApplication(String name) {
        this.name = name;
        this.left = null;
        this.right = null;
    }

    static void inorder(TraversalApplication node, List<String> result) {
        if(node == null) return;
        inorder(node.left, result);
        result.add(node.name);
        inorder(node.right, result);
    }

    static void preorder(TraversalApplication node, List<String> result) {
        if(node == null) return;
        result.add(node.name);
        preorder(node.left, result);
        preorder(node.right, result);
    }

    static void postorder(TraversalApplication node, List<String> result) {
        if(node == null) return;
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.name);
    }

    public static void main(String[] args) {
        TraversalApplication root = new TraversalApplication("root");
        TraversalApplication home = new TraversalApplication("home");
        TraversalApplication var = new TraversalApplication("var");
        TraversalApplication user = new TraversalApplication("user");
        TraversalApplication docs = new TraversalApplication("docs");
        TraversalApplication log = new TraversalApplication("log");
        TraversalApplication config = new TraversalApplication("config");

        root.left = home;
        root.right = var;
        home.left = user;
        home.right = docs;
        var.right = log;
        user.left = config;

        System.out.println("a) For listing files in alphabetical order in a BST, use Inorder Traversal");
        System.out.println("   because inorder traversal of a BST visits nodes in sorted order.");

        System.out.println("\nb) To calculate total size of a directory, use Postorder Traversal");
        System.out.println("   because we need to know sizes of subdirectories before computing parent size.");

        System.out.println("\nc) To create a backup copying from root, use Preorder Traversal");
        System.out.println("   because we need to create parent directories before copying children into them.");

        List<String> inorderResult = new ArrayList<>();
        inorder(root, inorderResult);
        System.out.println("\nd) Inorder Traversal: " + inorderResult);

        List<String> preorderResult = new ArrayList<>();
        preorder(root, preorderResult);
        System.out.println("   Preorder Traversal: " + preorderResult);

        List<String> postorderResult = new ArrayList<>();
        postorder(root, postorderResult);
        System.out.println("   Postorder Traversal: " + postorderResult);

        System.out.println("\ne) Postorder traversal processes children before parent, so all files");
        System.out.println("   inside a directory are deleted first, then the empty directory itself");
        System.out.println("   is deleted. This prevents trying to delete a non-empty directory.");
    }
}
