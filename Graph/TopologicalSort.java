import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// import java.util.Stack;

public class TopologicalSort {
    public static class Edge {
        int src;
        int dest;

        public Edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
        
    }

    // Topological sort using DFS
    // public static void topSort(ArrayList<Edge> graph[]){
    //     boolean visited[] = new boolean[graph.length];
    //     Stack<Integer> s = new Stack<>();

    //     for(int i=0;i<graph.length;i++){
    //         if (!visited[i]) {
    //             topSortUtil(graph,i,visited,s); // modified dfs
    //         }
    //     }

    //     while (!s.isEmpty()) {
    //         System.out.print(s.pop()+" ");
    //     }
    // }

    // public static void topSortUtil(ArrayList<Edge> graph[],int curr,boolean visited[],Stack<Integer> s){
    //     visited[curr] = true;
    //     for(int i=0;i<graph[curr].size();i++){
    //         Edge e = graph[curr].get(i);
    //         if (!visited[e.dest]) {
    //             topSortUtil(graph, e.dest, visited, s);
    //         }
    //     }
    //     s.push(curr);
    // }

    // Topological sort using BFS
    public static void calculateInDegree(ArrayList<Edge> graph[],int inDeg[]){
        for(int i=0;i<graph.length;i++){
            int vertex = i;
            for(int j=0;j<graph[vertex].size();j++){
                Edge e = graph[vertex].get(j);
                inDeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[]){
        int inDeg[] = new int[graph.length];
        calculateInDegree(graph, inDeg);
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<inDeg.length;i++){
            if (inDeg[i]==0) {
                q.add(i);
            }
        }

        //BFS
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");
            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                inDeg[e.dest]--;
                if (inDeg[e.dest]==0) {
                    q.add(e.dest);
                }
            }
        }

        System.out.println();
    }
    public static void main(String[] args) {
        int v = 6;
        @SuppressWarnings({ "unchecked" })
        ArrayList<Edge> graph[] = (ArrayList<Edge>[]) new ArrayList[v];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        topSort(graph);
    }
}