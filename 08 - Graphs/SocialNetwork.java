import java.util.*;

class SocialNetwork {
    Map<String, List<String>> adjacencyList;

    SocialNetwork() {
        adjacencyList = new HashMap<>();
    }

    void addUser(String user) {
        adjacencyList.putIfAbsent(user, new ArrayList<>());
    }

    void addFriendship(String user1, String user2) {
        adjacencyList.get(user1).add(user2);
        adjacencyList.get(user2).add(user1);
    }

    List<String> getFriends(String user) {
        return adjacencyList.getOrDefault(user, new ArrayList<>());
    }

    boolean areDirectlyConnected(String user1, String user2) {
        return adjacencyList.containsKey(user1) && adjacencyList.get(user1).contains(user2);
    }

    int shortestPath(String source, String target) {
        if(source.equals(target)) return 0;
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distance = new HashMap<>();
        queue.add(source);
        distance.put(source, 0);

        while(!queue.isEmpty()) {
            String current = queue.poll();
            for(String neighbor : adjacencyList.get(current)) {
                if(!distance.containsKey(neighbor)) {
                    distance.put(neighbor, distance.get(current) + 1);
                    if(neighbor.equals(target)) return distance.get(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return -1;
    }

    List<String> shortestPathRoute(String source, String target) {
        if(source.equals(target)) return Arrays.asList(source);
        Queue<String> queue = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();
        parent.put(source, null);
        queue.add(source);

        while(!queue.isEmpty()) {
            String current = queue.poll();
            for(String neighbor : adjacencyList.get(current)) {
                if(!parent.containsKey(neighbor)) {
                    parent.put(neighbor, current);
                    if(neighbor.equals(target)) {
                        List<String> path = new ArrayList<>();
                        String node = target;
                        while(node != null) {
                            path.add(node);
                            node = parent.get(node);
                        }
                        Collections.reverse(path);
                        return path;
                    }
                    queue.add(neighbor);
                }
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        String[] users = {"Alice", "Bob", "Charlie", "David", "Eve"};
        for(String user : users) {
            network.addUser(user);
        }

        network.addFriendship("Alice", "Bob");
        network.addFriendship("Alice", "Charlie");
        network.addFriendship("Bob", "David");
        network.addFriendship("Charlie", "Eve");
        network.addFriendship("David", "Eve");

        System.out.println("=== Problem 1: Social Network Connection ===\n");

        System.out.println("a) Graph Representation: Adjacency List");
        System.out.println("   Justification: Social networks are sparse graphs (users have few");
        System.out.println("   friends compared to total users). Adjacency list uses O(V + E) space");
        System.out.println("   vs O(V^2) for adjacency matrix, making it far more memory efficient.");
        System.out.println("   Also provides O(1) average time to add friendships.\n");
        System.out.println("   Current Network:");
        for(String user : users) {
            System.out.println("   " + user + " -> " + network.getFriends(user));
        }

        System.out.println("\nb) All friends of Alice: " + network.getFriends("Alice"));
        System.out.println("   Algorithm: Direct lookup in adjacency list - O(1) average time");

        System.out.println("\nc) Are Bob and Eve directly connected? " + network.areDirectlyConnected("Bob", "Eve"));
        System.out.println("   Algorithm: Check if Eve exists in Bob's adjacency list - O(degree) time");

        int separation = network.shortestPath("Alice", "Eve");
        List<String> path = network.shortestPathRoute("Alice", "Eve");
        System.out.println("\nd) Degree of separation between Alice and Eve: " + separation);
        System.out.println("   Shortest path: " + path);
        System.out.println("   Algorithm: BFS from Alice to Eve - guarantees shortest path in");
        System.out.println("   unweighted graphs. Time: O(V + E), Space: O(V)");
    }
}
