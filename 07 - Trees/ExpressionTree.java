import java.util.*;

class ExpressionTree {
    String value;
    ExpressionTree left, right;

    ExpressionTree(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    static void postorder(ExpressionTree node, List<String> result) {
        if(node == null) return;
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.value);
    }

    static String inorderWithParentheses(ExpressionTree node) {
        if(node == null) return "";
        if(node.left == null && node.right == null) return node.value;
        String left = inorderWithParentheses(node.left);
        String right = inorderWithParentheses(node.right);
        return "(" + left + " " + node.value + " " + right + ")";
    }

    static void preorder(ExpressionTree node, List<String> result) {
        if(node == null) return;
        result.add(node.value);
        preorder(node.left, result);
        preorder(node.right, result);
    }

    static int evaluatePostorder(ExpressionTree node) {
        if(node.left == null && node.right == null) return Integer.parseInt(node.value);
        int leftVal = evaluatePostorder(node.left);
        int rightVal = evaluatePostorder(node.right);
        switch(node.value) {
            case "+": return leftVal + rightVal;
            case "-": return leftVal - rightVal;
            case "*": return leftVal * rightVal;
            case "/": return leftVal / rightVal;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        ExpressionTree multiply = new ExpressionTree("*");
        ExpressionTree plus = new ExpressionTree("+");
        ExpressionTree minus = new ExpressionTree("-");
        ExpressionTree three = new ExpressionTree("3");
        ExpressionTree five = new ExpressionTree("5");
        ExpressionTree eight = new ExpressionTree("8");
        ExpressionTree two = new ExpressionTree("2");

        multiply.left = plus;
        multiply.right = minus;
        plus.left = three;
        plus.right = five;
        minus.left = eight;
        minus.right = two;

        List<String> postorderResult = new ArrayList<>();
        postorder(multiply, postorderResult);
        System.out.println("a) Postorder (Postfix Notation): " + String.join(" ", postorderResult));
        System.out.println("   This represents postfix notation where operands come before operators.");
        System.out.println("   Read left-to-right: push operands to stack, pop two when operator found.");

        System.out.println("\nb) Inorder (Infix with Parentheses): " + inorderWithParentheses(multiply));
        System.out.println("   Adding parentheses during inorder gives the original expression.");

        List<String> preorderResult = new ArrayList<>();
        preorder(multiply, preorderResult);
        System.out.println("\nc) Preorder (Prefix Notation): " + String.join(" ", preorderResult));
        System.out.println("   Prefix notation places operator before its operands.");

        System.out.println("\nd) Stack-based Postorder Evaluation Algorithm:");
        System.out.println("   1. Traverse tree in postorder: 3 5 + 8 2 - *");
        System.out.println("   2. Read tokens left to right:");
        System.out.println("      - Push 3 -> Stack: [3]");
        System.out.println("      - Push 5 -> Stack: [3, 5]");
        System.out.println("      - Operator +: Pop 5 and 3, compute 3+5=8, push 8 -> Stack: [8]");
        System.out.println("      - Push 8 -> Stack: [8, 8]");
        System.out.println("      - Push 2 -> Stack: [8, 8, 2]");
        System.out.println("      - Operator -: Pop 2 and 8, compute 8-2=6, push 6 -> Stack: [8, 6]");
        System.out.println("      - Operator *: Pop 6 and 8, compute 8*6=48, push 48 -> Stack: [48]");
        System.out.println("   3. Final result: " + evaluatePostorder(multiply));

        System.out.println("\ne) Expression Tree for: a * b + c / d - e");
        ExpressionTree sub = new ExpressionTree("-");
        ExpressionTree add = new ExpressionTree("+");
        ExpressionTree mul = new ExpressionTree("*");
        ExpressionTree div = new ExpressionTree("/");
        ExpressionTree a = new ExpressionTree("a");
        ExpressionTree b = new ExpressionTree("b");
        ExpressionTree c = new ExpressionTree("c");
        ExpressionTree d = new ExpressionTree("d");
        ExpressionTree e = new ExpressionTree("e");

        sub.left = add;
        sub.right = e;
        add.left = mul;
        add.right = div;
        mul.left = a;
        mul.right = b;
        div.left = c;
        div.right = d;

        List<String> inorderList = new ArrayList<>();
        inorderTraversal(sub, inorderList);
        System.out.println("   Inorder:   " + String.join(" ", inorderList));

        List<String> preorderList = new ArrayList<>();
        preorder(sub, preorderList);
        System.out.println("   Preorder:  " + String.join(" ", preorderList));

        List<String> postorderList = new ArrayList<>();
        postorder(sub, postorderList);
        System.out.println("   Postorder: " + String.join(" ", postorderList));
    }

    static void inorderTraversal(ExpressionTree node, List<String> result) {
        if(node == null) return;
        inorderTraversal(node.left, result);
        result.add(node.value);
        inorderTraversal(node.right, result);
    }
}
