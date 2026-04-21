import java.util.*;

class CoursePrerequisite {
    Map<String, List<String>> adjList;
    Set<String> courses;

    CoursePrerequisite() {
        adjList = new HashMap<>();
        courses = new LinkedHashSet<>();
    }

    void addCourse(String course) {
        courses.add(course);
        adjList.putIfAbsent(course, new ArrayList<>());
    }

    void addPrerequisite(String from, String to) {
        adjList.get(from).add(to);
    }

    boolean hasCycleDFS(String node, Set<String> visited, Set<String> recursionStack) {
        visited.add(node);
        recursionStack.add(node);

        for(String neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if(!visited.contains(neighbor)) {
                if(hasCycleDFS(neighbor, visited, recursionStack)) return true;
            } else if(recursionStack.contains(neighbor)) {
                return true;
            }
        }
        recursionStack.remove(node);
        return false;
    }

    boolean hasCycle() {
        Set<String> visited = new HashSet<>();
        Set<String> recursionStack = new HashSet<>();
        for(String course : courses) {
            if(!visited.contains(course)) {
                if(hasCycleDFS(course, visited, recursionStack)) return true;
            }
        }
        return false;
    }

    Set<String> findAllPrerequisites(String target) {
        Map<String, List<String>> reverseGraph = new HashMap<>();
        for(String course : courses) {
            reverseGraph.putIfAbsent(course, new ArrayList<>());
        }
        for(String course : courses) {
            for(String next : adjList.getOrDefault(course, new ArrayList<>())) {
                reverseGraph.get(next).add(course);
            }
        }

        Set<String> prerequisites = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(target);

        while(!queue.isEmpty()) {
            String current = queue.poll();
            for(String prereq : reverseGraph.getOrDefault(current, new ArrayList<>())) {
                if(!prerequisites.contains(prereq)) {
                    prerequisites.add(prereq);
                    queue.add(prereq);
                }
            }
        }
        return prerequisites;
    }

    List<String> topologicalSort() {
        Map<String, Integer> inDegree = new HashMap<>();
        for(String course : courses) {
            inDegree.put(course, 0);
        }
        for(String course : courses) {
            for(String next : adjList.getOrDefault(course, new ArrayList<>())) {
                inDegree.put(next, inDegree.get(next) + 1);
            }
        }

        Queue<String> queue = new LinkedList<>();
        for(String course : courses) {
            if(inDegree.get(course) == 0) queue.add(course);
        }

        List<String> order = new ArrayList<>();
        while(!queue.isEmpty()) {
            String current = queue.poll();
            order.add(current);
            for(String next : adjList.getOrDefault(current, new ArrayList<>())) {
                inDegree.put(next, inDegree.get(next) - 1);
                if(inDegree.get(next) == 0) queue.add(next);
            }
        }
        return order;
    }

    public static void main(String[] args) {
        CoursePrerequisite system = new CoursePrerequisite();

        String[] courseList = {"CS101", "CS102", "CS201", "CS202", "MATH101"};
        for(String course : courseList) {
            system.addCourse(course);
        }

        system.addPrerequisite("CS101", "CS102");
        system.addPrerequisite("CS101", "CS201");
        system.addPrerequisite("CS102", "CS202");
        system.addPrerequisite("MATH101", "CS201");

        System.out.println("=== Problem 2: Course Prerequisite System ===\n");

        System.out.println("a) Graph Representation: Directed Adjacency List");
        System.out.println("   Directed edges represent prerequisite relationships.");
        System.out.println("   Edge A -> B means course A must be taken before B.\n");
        System.out.println("   Current Prerequisite Structure:");
        for(String course : courseList) {
            List<String> next = system.adjList.get(course);
            if(!next.isEmpty()) {
                System.out.println("   " + course + " -> " + next);
            }
        }

        System.out.println("\nb) Cycle Detection Result: " + (system.hasCycle() ? "Circular dependency found!" : "No circular dependency"));
        System.out.println("   Algorithm: DFS with recursion stack tracking. If we revisit a node");
        System.out.println("   that's already in the current recursion stack, a cycle exists.");
        System.out.println("   Time: O(V + E), Space: O(V)");

        Set<String> prereqs = system.findAllPrerequisites("CS202");
        System.out.println("\nc) All prerequisites for CS202: " + prereqs);
        System.out.println("   Algorithm: BFS on reversed graph starting from CS202.");
        System.out.println("   Reverse edges so we can traverse backward through prerequisites.");

        List<String> order = system.topologicalSort();
        System.out.println("\nd) Valid course order (Topological Sort): " + order);
        System.out.println("   Algorithm: Kahn's Algorithm (BFS-based topological sort).");
        System.out.println("   Start with courses having no prerequisites (in-degree 0),");
        System.out.println("   process them, reduce in-degrees, and repeat.");
        System.out.println("   Time: O(V + E), Space: O(V)");

        System.out.println("\n--- Testing Cycle Detection with artificial cycle ---");
        CoursePrerequisite cyclic = new CoursePrerequisite();
        for(String course : courseList) cyclic.addCourse(course);
        cyclic.addPrerequisite("CS101", "CS102");
        cyclic.addPrerequisite("CS102", "CS201");
        cyclic.addPrerequisite("CS201", "CS101");
        System.out.println("   Added: CS101->CS102->CS201->CS101");
        System.out.println("   Cycle Detected: " + cyclic.hasCycle());
    }
}
