import java.util.*;

class TreeTerminology {
    String name;
    List<TreeTerminology> children;

    TreeTerminology(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    void addChild(TreeTerminology child) {
        this.children.add(child);
    }

    void findLeafNodes(TreeTerminology node, List<String> leaves) {
        if(node.children.isEmpty()) {
            leaves.add(node.name);
            return;
        }
        for(TreeTerminology child : node.children) {
            findLeafNodes(child, leaves);
        }
    }

    int findHeight(TreeTerminology node) {
        if(node.children.isEmpty()) return 0;
        int maxHeight = 0;
        for(TreeTerminology child : node.children) {
            maxHeight = Math.max(maxHeight, findHeight(child));
        }
        return maxHeight + 1;
    }

    int findDepth(TreeTerminology node, String target, int currentDepth) {
        if(node.name.equals(target)) return currentDepth;
        for(TreeTerminology child : node.children) {
            int depth = findDepth(child, target, currentDepth + 1);
            if(depth != -1) return depth;
        }
        return -1;
    }

    boolean findAncestors(TreeTerminology node, String target, List<String> ancestors) {
        if(node.name.equals(target)) return true;
        for(TreeTerminology child : node.children) {
            if(findAncestors(child, target, ancestors)) {
                ancestors.add(node.name);
                return true;
            }
        }
        return false;
    }

    int findDegree(TreeTerminology node, String target) {
        if(node.name.equals(target)) return node.children.size();
        for(TreeTerminology child : node.children) {
            int degree = findDegree(child, target);
            if(degree != -1) return degree;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeTerminology ceo = new TreeTerminology("CEO");
        TreeTerminology cto = new TreeTerminology("CTO");
        TreeTerminology cfo = new TreeTerminology("CFO");
        TreeTerminology devLead = new TreeTerminology("Dev Lead");
        TreeTerminology hr = new TreeTerminology("HR");
        TreeTerminology dev1 = new TreeTerminology("Dev1");
        TreeTerminology dev2 = new TreeTerminology("Dev2");

        ceo.addChild(cto);
        ceo.addChild(cfo);
        cto.addChild(devLead);
        cto.addChild(hr);
        cfo.addChild(hr);
        devLead.addChild(dev1);
        devLead.addChild(dev2);

        List<String> leaves = new ArrayList<>();
        ceo.findLeafNodes(ceo, leaves);
        System.out.println("a) Leaf Nodes: " + leaves);

        System.out.println("b) Height of Tree: " + ceo.findHeight(ceo));

        System.out.println("c) Depth of Dev Lead: " + ceo.findDepth(ceo, "Dev Lead", 0));

        List<String> ancestors = new ArrayList<>();
        ceo.findAncestors(ceo, "Dev1", ancestors);
        System.out.println("d) Ancestors of Dev1: " + ancestors);

        System.out.println("e) Degree of CTO: " + ceo.findDegree(ceo, "CTO"));
    }
}
