class ProcessNode {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnAroundTime;
    ProcessNode next;

    public ProcessNode(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

public class RoundRobinScheduler {
    private ProcessNode tail;
    private int totalProcesses = 0;

    public void add(int pid, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(pid, burstTime, priority);
        totalProcesses++;
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void remove(int pid) {
        if (tail == null) return;
        ProcessNode current = tail.next;
        ProcessNode prev = tail;
        do {
            if (current.pid == pid) {
                if (current == tail && current.next == tail) {
                    tail = null;
                } else {
                    prev.next = current.next;
                    if (current == tail) tail = prev;
                }
                totalProcesses--;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != tail.next);
    }

    public void simulate(int timeQuantum) {
        if (tail == null) return;
        ProcessNode current = tail.next;
        int currentTime = 0;
        int completed = 0;
        int target = totalProcesses;

        while (completed < target) {
            if (current.remainingTime > 0) {
                if (current.remainingTime > timeQuantum) {
                    currentTime += timeQuantum;
                    current.remainingTime -= timeQuantum;
                } else {
                    currentTime += current.remainingTime;
                    current.waitingTime = currentTime - current.burstTime;
                    current.turnAroundTime = currentTime;
                    current.remainingTime = 0;
                    completed++;
                }
            }
            current = current.next;
            display();
        }
    }

    public void display() {
        if (tail == null) return;
        ProcessNode current = tail.next;
        do {
            System.out.print("P" + current.pid + "[" + current.remainingTime + "] ");
            current = current.next;
        } while (current != tail.next);
        System.out.println();
    }

    public void calculateAverages() {
        if (tail == null) return;
        double totalWait = 0, totalTurn = 0;
        ProcessNode current = tail.next;
        do {
            totalWait += current.waitingTime;
            totalTurn += current.turnAroundTime;
            current = current.next;
        } while (current != tail.next);
        System.out.println("Avg Wait: " + (totalWait / totalProcesses));
        System.out.println("Avg Turn: " + (totalTurn / totalProcesses));
    }
}