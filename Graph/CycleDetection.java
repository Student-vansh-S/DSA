import java.util.ArrayList;

public class CycleDetection {
    static class Edge {
        int src;
        int des;

        public Edge(int src,int des){
            this.src = src;
            this.des = des;
        }
        
    }

    public static boolean cycleDetection(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if (!visited[i]) {
                if(cycleDetectionUtil(graph,visited,i,-1)){
                    return true; // cycle exists in one of the parts
                }
            }
        }
        return false;
    }

    public static boolean cycleDetectionUtil(ArrayList<Edge> graph[],boolean visited[],int curr,int parent){
        visited[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if (!visited[e.des]) {
                if (cycleDetectionUtil(graph,visited,e.des,curr)) {
                    return true;
                }
            }
            else if (visited[e.des] && e.des!=parent) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        int vertex = 5;
        @SuppressWarnings("unchecked") // for warning removal
        ArrayList<Edge> graph[] = (ArrayList<Edge>[]) new ArrayList[vertex]; 
        
        for(int i=0;i<vertex;i++){  // null -> empty arraylist
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        // 1 vertex
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        // 2 vertex
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        // 3 vertex
        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));

        // 4 vertex
        graph[4].add(new Edge(4,3));

        System.out.println(cycleDetection(graph));

    }
}
