import java.util.*;

class CityRoadNetwork {
    Map<String, List<int[]>> adjList;
    Map<String, Map<String, Integer>> weightMap;
    List<String> vertices;

    CityRoadNetwork() {
        adjList = new HashMap<>();
        weightMap = new HashMap<>();
        vertices = new ArrayList<>();
    }

    void addIntersection(String name) {
        vertices.add(name);
        adjList.putIfAbsent(name, new ArrayList<>());
        weightMap.putIfAbsent(name, new HashMap<>());
    }

    void addOneWayRoad(String from, String to, int distance) {
        int toIndex = vertices.indexOf(to);
        adjList.get(from).add(new int[]{toIndex, distance});
        weightMap.get(from).put(to, distance);
    }

    void addTwoWayRoad(String a, String b, int distance) {
        addOneWayRoad(a, b, distance);
        addOneWayRoad(b, a, distance);
    }

    Set<String> findReachable(String start) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty()) {
            String current = queue.poll();
            for(String neighbor : weightMap.get(current).keySet()) {
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return visited;
    }

    List<String> bfsFewestEdges(String start, String end) {
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
            for(String neighbor : weightMap.get(current).keySet()) {
                if(!parent.containsKey(neighbor)) {
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
        return new ArrayList<>();
    }

    int pathDistance(List<String> path) {
        int total = 0;
        for(int i = 0; i < path.size() - 1; i++) {
            total += weightMap.get(path.get(i)).get(path.get(i + 1));
        }
        return total;
    }

    void dfsAllPaths(String current, String end, Set<String> visited, List<String> currentPath, List<List<String>> allPaths) {
        visited.add(current);
        currentPath.add(current);

        if(current.equals(end)) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            for(String neighbor : weightMap.get(current).keySet()) {
                if(!visited.contains(neighbor)) {
                    dfsAllPaths(neighbor, end, visited, currentPath, allPaths);
                }
            }
        }

        currentPath.remove(currentPath.size() - 1);
        visited.remove(current);
    }

    public static void main(String[] args) {
        CityRoadNetwork city = new CityRoadNetwork();

        String[] intersections = {"A", "B", "C", "D", "E"};
        for(String intersection : intersections) {
            city.addIntersection(intersection);
        }

        city.addOneWayRoad("A", "B", 5);
        city.addTwoWayRoad("B", "C", 3);
        city.addTwoWayRoad("A", "D", 7);
        city.addOneWayRoad("D", "E", 2);
        city.addOneWayRoad("C", "E", 4);

        System.out.println("=== Problem 3: City Road Network ===\n");

        System.out.println("a) Graph Representation: Directed Weighted Adjacency List");
        System.out.println("   - Directed: because some roads are one-way");
        System.out.println("   - Weighted: because roads have distances in km");
        System.out.println("   - Two-way roads are stored as two directed edges");
        System.out.println("   - Adjacency list chosen over matrix for sparse road networks\n");
        System.out.println("   Road Network:");
        for(String v : intersections) {
            Map<String, Integer> neighbors = city.weightMap.get(v);
            if(!neighbors.isEmpty()) {
                for(Map.Entry<String, Integer> entry : neighbors.entrySet()) {
                    System.out.println("   " + v + " -> " + entry.getKey() + " (" + entry.getValue() + " km)");
                }
            }
        }

        Set<String> reachable = city.findReachable("A");
        System.out.println("\nb) All intersections reachable from A: " + reachable);
        System.out.println("   Algorithm: BFS/DFS traversal from A, marking visited nodes.");
        System.out.println("   Time: O(V + E), Space: O(V)");

        List<String> bfsPath = city.bfsFewestEdges("A", "E");
        System.out.println("\nc) BFS path with fewest turns from A to E: " + bfsPath);
        System.out.println("   Number of edges (turns): " + (bfsPath.size() - 1));
        System.out.println("   Total distance: " + city.pathDistance(bfsPath) + " km");
        System.out.println("   BFS explores level by level, so the first path found to E has");
        System.out.println("   the minimum number of edges (fewest intermediate intersections).");

        System.out.println("\nd) Why DFS might not find the shortest distance path:");
        List<List<String>> allPaths = new ArrayList<>();
        city.dfsAllPaths("A", "E", new HashSet<>(), new ArrayList<>(), allPaths);
        System.out.println("   All possible paths from A to E:");
        for(List<String> path : allPaths) {
            System.out.println("   " + path + " -> Distance: " + city.pathDistance(path) + " km");
        }
        System.out.println("\n   DFS explores one branch completely before backtracking.");
        System.out.println("   It finds A path, not necessarily the SHORTEST distance path.");
        System.out.println("   DFS might go A->D->E (9 km) or A->B->C->E (12 km) depending on");
        System.out.println("   the order neighbors are visited. It doesn't compare distances");
        System.out.println("   across different branches. For shortest weighted path, use");
        System.out.println("   Dijkstra's algorithm instead.");
    }
}
