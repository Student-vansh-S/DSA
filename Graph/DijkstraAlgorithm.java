import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    public static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int s,int d,int wt){
            this.src = s;
            this.dest = d;
            this.weight = wt;
        }
    }

    public static class Pair implements Comparable<Pair> {
        int node;
        int path;
        
        public Pair(int n,int p){
            this.node = n;
            this.path = p;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path; // path based sorting for my pairs
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src){
        int dest[] = new int[graph.length]; // dest[i] -> src to i
        for(int i=0;i<graph.length;i++){
            if (i!=src) {
                dest[i] = Integer.MAX_VALUE; // + infinity
            }
        }

        boolean visit[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visit[curr.node]) {
                visit[curr.node] = true;
                // neighbours
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;
                    if (dest[u]+wt < dest[v]) { // update distance of src to v
                        dest[v] = dest[u]+wt;
                        pq.add(new Pair(v, dest[v]));
                    }
                }
            }
        }
        // print all source to vertices shortest path
        for(int i=0;i<dest.length;i++){
            System.out.print(dest[i]+" ");
        }
        System.out.println();
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));        
        graph[0].add(new Edge(0, 2, 4));
        
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
        
        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));
        
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    public static void main(String[] args) {
        int vertex = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[vertex];
        createGraph(graph);
        dijkstra(graph, 0);
    }
}
