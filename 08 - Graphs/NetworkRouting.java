import java.util.*;

class NetworkRouting {
    int vertexCount;
    String[] routerNames;
    int[][] adjMatrix;
    Map<String, List<String>> adjListMap;

    NetworkRouting(String[] routers) {
        this.vertexCount = routers.length;
        this.routerNames = routers;
        this.adjMatrix = new int[vertexCount][vertexCount];
        this.adjListMap = new LinkedHashMap<>();
        for(String router : routers) {
            adjListMap.put(router, new ArrayList<>());
        }
    }

    int indexOf(String router) {
        for(int i = 0; i < routerNames.length; i++) {
            if(routerNames[i].equals(router)) return i;
        }
        return -1;
    }

    void addConnection(String r1, String r2) {
        int i = indexOf(r1), j = indexOf(r2);
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
        adjListMap.get(r1).add(r2);
        adjListMap.get(r2).add(r1);
    }

    void printAdjMatrix() {
        System.out.print("      ");
        for(String name : routerNames) System.out.printf("%-4s", name);
        System.out.println();
        for(int i = 0; i < vertexCount; i++) {
            System.out.printf("   %-4s", routerNames[i]);
            for(int j = 0; j < vertexCount; j++) {
                System.out.printf("%-4d", adjMatrix[i][j]);
            }
            System.out.println();
        }
    }

    void printAdjList() {
        for(String router : routerNames) {
            System.out.println("   " + router + " -> " + adjListMap.get(router));
        }
    }

    boolean isConnected() {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(routerNames[0]);
        visited.add(routerNames[0]);

        while(!queue.isEmpty()) {
            String current = queue.poll();
            for(String neighbor : adjListMap.get(current)) {
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return visited.size() == vertexCount;
    }

    List<List<String>> findAllPaths(String start, String end, Set<String> excludedEdges) {
        List<List<String>> allPaths = new ArrayList<>();
        dfsAllPaths(start, end, new HashSet<>(), new ArrayList<>(), allPaths, excludedEdges);
        return allPaths;
    }

    void dfsAllPaths(String current, String end, Set<String> visited, List<String> path,
                     List<List<String>> allPaths, Set<String> excludedEdges) {
        visited.add(current);
        path.add(current);

        if(current.equals(end)) {
            allPaths.add(new ArrayList<>(path));
        } else {
            for(String neighbor : adjListMap.get(current)) {
                String edge1 = current + "-" + neighbor;
                String edge2 = neighbor + "-" + current;
                if(!visited.contains(neighbor) && !excludedEdges.contains(edge1) && !excludedEdges.contains(edge2)) {
                    dfsAllPaths(neighbor, end, visited, path, allPaths, excludedEdges);
                }
            }
        }

        path.remove(path.size() - 1);
        visited.remove(current);
    }

    int bfsMinHops(String start, String end) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distance = new HashMap<>();
        queue.add(start);
        distance.put(start, 0);

        while(!queue.isEmpty()) {
            String current = queue.poll();
            for(String neighbor : adjListMap.get(current)) {
                if(!distance.containsKey(neighbor)) {
                    distance.put(neighbor, distance.get(current) + 1);
                    if(neighbor.equals(end)) return distance.get(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return -1;
    }

    List<String> bfsShortestPath(String start, String end) {
        Queue<String> queue = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();
        parent.put(start, null);
        queue.add(start);

        while(!queue.isEmpty()) {
            String current = queue.poll();
            if(current.equals(end)) {
                List<String> path = new ArrayList<>();
                String node = end;
                while(node != null) {
                    path.add(node);
                    node = parent.get(node);
                }
                Collections.reverse(path);
                return path;
            }
            for(String neighbor : adjListMap.get(current)) {
                if(!parent.containsKey(neighbor)) {
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        String[] routers = {"R1", "R2", "R3", "R4", "R5", "R6"};
        NetworkRouting network = new NetworkRouting(routers);

        network.addConnection("R1", "R2");
        network.addConnection("R1", "R3");
        network.addConnection("R2", "R4");
        network.addConnection("R3", "R4");
        network.addConnection("R4", "R5");
        network.addConnection("R5", "R6");

        System.out.println("=== Problem 5: Network Packet Routing ===\n");

        System.out.println("a) Adjacency Matrix Representation:");
        network.printAdjMatrix();
        System.out.println("\n   Adjacency List Representation:");
        network.printAdjList();

        System.out.println("\nb) Space Complexity Comparison:");
        System.out.println("   V = " + routers.length + " vertices, E = 6 edges");
        System.out.println("   Adjacency Matrix: O(V^2) = O(36) - stores " + (routers.length * routers.length) + " entries");
        System.out.println("   Adjacency List:   O(V + 2E) = O(6 + 12) = O(18) - stores vertices + edge references");
        System.out.println("   For sparse networks (E << V^2), adjacency list is more space efficient.");

        System.out.println("\nc) Network Connectivity Check: " + (network.isConnected() ? "Network is fully connected" : "Network is NOT connected"));
        System.out.println("   Algorithm: BFS from any router. If all routers are visited,");
        System.out.println("   the network is connected. Time: O(V + E)");

        System.out.println("\nd) If R4-R5 connection fails:");
        Set<String> excludedEdges = new HashSet<>();
        excludedEdges.add("R4-R5");
        List<List<String>> altPaths = network.findAllPaths("R1", "R6", excludedEdges);
        if(altPaths.isEmpty()) {
            System.out.println("   No alternative paths exist from R1 to R6!");
            System.out.println("   R4-R5 is a bridge edge - its removal disconnects R6 from the rest.");
        } else {
            System.out.println("   Alternative paths from R1 to R6:");
            for(List<String> path : altPaths) {
                System.out.println("   " + path + " (hops: " + (path.size() - 1) + ")");
            }
        }
        System.out.println("   Algorithm: DFS to find all paths while excluding the failed edge.");
        System.out.println("   The edge R4-R5 is a bridge - removing it disconnects R5 and R6.");

        int hops = network.bfsMinHops("R1", "R6");
        List<String> shortestPath = network.bfsShortestPath("R1", "R6");
        System.out.println("\ne) Minimum hops from R1 to R6 (original network): " + hops);
        System.out.println("   Shortest path: " + shortestPath);
        System.out.println("   Algorithm: BFS from R1. Each level represents one hop.");
        System.out.println("   BFS guarantees minimum hops in unweighted graphs.");
        System.out.println("   Time: O(V + E), Space: O(V)");
    }
}
