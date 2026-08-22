import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

       List<List<Integer>> graph = new ArrayList<>();

       for(int i=0; i<numCourses; i++)
       {
            graph.add(new ArrayList<>());
       }

       //build graph
       int indegree[] = new int[numCourses];

       for(int edge[] : prerequisites)
       {
            int from = edge[1];
            int to = edge[0];

            graph.get(from).add(to);
            indegree[to]++;
       }

       // put all node with indegree of 0 into q
       Queue<Integer> q = new LinkedList<>();

       for(int i=0; i<numCourses; i++)
       {
            if(indegree[i] == 0)
            {
                q.offer(i);
            }
       }

    //Process
    int result[] = new int[numCourses];
    int k = 0;
    int count = 0;
    while(!q.isEmpty())
    {
        int node = q.poll();
        result[k++] = node;
        count++;

        for(int neighbor : graph.get(node))
        {
            indegree[neighbor]--;

            if(indegree[neighbor] == 0)
            {
                q.offer(neighbor);
            }
        }
    }

    if(count == numCourses)
    {
    
    return result;
    }

    return new int[]{};

    }
}

// class Solution {
//     public static class Edge {
//         int src;
//         int dest;

//         public Edge(int s, int d) {
//             this.src = s;
//             this.dest = d;
//         }
//     }

//     public static void createGraph(ArrayList<Edge> graph[], int[][] pr) {
//         for (int i = 0; i < graph.length; i++) {
//             graph[i] = new ArrayList<>();
//         }

//         for (int i = 0; i < pr.length; i++) {
//             int course = pr[i][0];
//             int prerequisite = pr[i][1];
//             graph[prerequisite].add(new Edge(prerequisite, course));
//         }
//     }

//     public static void calculateInDegree(ArrayList<Edge> graph[],int inDeg[]) {
//         for (int i = 0; i < graph.length; i++) {
//             for (int j = 0; j < graph[i].size(); j++) {
//                 Edge e = graph[i].get(j);
//                 inDeg[e.dest]++;
//             }
//         }
//     }

//     public static int[] labeledCourses(ArrayList<Edge> graph[],int[] result) {
//         int inDeg[] = new int[graph.length];
//         calculateInDegree(graph, inDeg);
//         Queue<Integer> q = new LinkedList<>();
//         for (int i = 0; i < inDeg.length; i++) {
//             if (inDeg[i] == 0) {
//                 q.add(i);
//             }
//         }
//         int j = 0;
//         // BFS / Topological Sort
//         while (!q.isEmpty()) {
//             int curr = q.remove();
//             result[j] = curr;
//             j++;
//             for (int i = 0; i < graph[curr].size(); i++) {
//                 Edge e = graph[curr].get(i);
//                 inDeg[e.dest]--;
//                 if (inDeg[e.dest] == 0) {
//                     q.add(e.dest);
//                 }
//             }
//         }

//         // Cycle detected
//         if (j != graph.length) {
//             return new int[0];
//         }

//         return result;
//     }

//     public int[] findOrder(int numCourses,int[][] prerequisites) {
//         ArrayList<Edge>[] graph = new ArrayList[numCourses];
//         createGraph(graph, prerequisites);
//         int result[] = new int[numCourses];
//         return labeledCourses(graph, result);
//     }
// }
}
