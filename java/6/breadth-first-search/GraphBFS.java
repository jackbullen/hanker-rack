import java.util.*;

public class GraphBFS<T> {
    private HashMap<T, LinkedList<T>> adj;
    private Queue<T> queue;

    GraphBFS() {
        adj = new HashMap<>();
        queue = new LinkedList<>();
    }

    public void insertEdge(T u, T v) {
        // Undirected
        adj.putIfAbsent(u, new LinkedList<>());
        adj.putIfAbsent(v, new LinkedList<>());
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void BFS(T node) {
        HashMap<T, Integer> distance = new HashMap<>();
        distance.put(node, 0);
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.println(node + " " + distance.get(node));
            // Loop over all adjacent to node and add to queue if not visited
            for (T otherNode : adj.get(node)) {
                if (distance.getOrDefault(otherNode, -1) == -1) {
                    distance.put(otherNode, distance.get(node) + 1);
                    queue.add(otherNode);
                }
            }
        }
    }
}