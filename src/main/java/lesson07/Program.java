package lesson07;

/*
Реализовать программу, в которой задаётся граф из 10 вершин.
Задать рёбра и попробовать найти минимальный кратчайший путь
путь с помощью поиска в ширину.
 */

public class Program {
    public static void main(String[] args) {
/*        Graph g = new Graph(13);
        g.addEdge(0, 6);
        g.addEdge(0 ,1);
        g.addEdge(0, 2);
        g.addEdge(5, 3);
        g.addEdge(5, 4);
        g.addEdge(5, 0);
        g.addEdge(4, 6);
        g.addEdge(4, 3);

        g.addEdge(7,8);

        g.addEdge(9,10);
        g.addEdge(9,12);
        g.addEdge(9, 11);
        g.addEdge(11,12);

        DepthFirstPaths dfs = new DepthFirstPaths(g, 0);
        System.out.println(dfs.hasPathTo(5));
        System.out.println(dfs.hasPathTo(12));
        System.out.println(dfs.pathTo(5));

        BroadFirstPaths bfs = new BroadFirstPaths(g, 0);
        System.out.println(bfs.pathTo(5));
        System.out.println(bfs.hasPathTo(12));
        System.out.println(bfs.pathTo(5));
        System.out.println(bfs.distTo(5));*/

        Graph g = new Graph(10);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 7);
        g.addEdge(2, 3);
        g.addEdge(3, 7);
        g.addEdge(3, 5);
        g.addEdge(5, 4);
        g.addEdge(7, 6);
        g.addEdge(6, 8);
        g.addEdge(8, 9);

        BroadFirstPaths bfs = new BroadFirstPaths(g, 0);
        System.out.println(bfs.pathTo(9));
    }
}
