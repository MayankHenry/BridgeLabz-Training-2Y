import java.util.List;
import java.util.Set;
import java.util.HashSet;

class FileNode {
    String name;
    boolean isDirectory;
    int size;
    List<FileNode> children;

    public FileNode(String name, boolean isDirectory, int size, List<FileNode> children) {
        this.name = name;
        this.isDirectory = isDirectory;
        this.size = size;
        this.children = children;
    }
}

public class DirectorySizeCalculator {
    public int calculateSize(FileNode node, Set<FileNode> visited) {
        if (node == null || visited.contains(node)) {
            return 0;
        }
        
        visited.add(node);
        
        if (!node.isDirectory) {
            return node.size;
        }
        
        int totalSize = 0;
        if (node.children != null) {
            for (FileNode child : node.children) {
                totalSize += calculateSize(child, visited);
            }
        }
        
        return totalSize;
    }
}