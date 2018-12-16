package lesson07;

import java.util.LinkedList;
import java.util.Queue;

public class BroadFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;
    private int source;
    private static final int INF = Integer.MAX_VALUE;

    public BroadFirstPaths(Graph g, int source) {
        this.source = source;
        marked = new boolean[g.vertexCount()];
        edgeTo = new int[g.vertexCount()];
        distTo = new int[g.vertexCount()];

        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = INF;
        }
        bfs(g, source);
    }

    private void bfs(Graph g, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        marked[source] = true;
        distTo[source] = 0;
        while (!queue.isEmpty()) {
            int currentVertex = queue.removeFirst();
            for (int vertex: g.adjList(currentVertex)) {
                if (!marked[vertex]) {
                    marked[vertex] = true;
                    edgeTo[vertex] = currentVertex;
                    distTo[vertex] = distTo[currentVertex] + 1;
                    queue.addLast(vertex);
                }
            }
        }
    }

    public boolean hasPathTo(int dest) {
        return marked[dest];
    }

    public LinkedList<Integer> pathTo(int dest) {
        if (!hasPathTo(dest)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = dest;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }

    public int distTo(int dest) {
        return distTo[dest];
    }
}
