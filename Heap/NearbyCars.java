import java.util.PriorityQueue;

public class NearbyCars {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;
        public Point(int x,int y, int distSq, int idx){
            this.x=x;
            this.y=y;
            this.distSq=distSq;
            this.idx=idx;
        }

        @Override
        public int compareTo(Point P2){
            return this.distSq - P2.distSq; // ascending order
        }
    }

    public static void main(String args[]){
        int cordinates[][] ={{3,3},{5,-1},{-2,4}};
        int k = 2;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0;i<cordinates.length;i++){
            int distSq = cordinates[i][0]*cordinates[i][0] + cordinates[i][1]*cordinates[i][1];
            pq.add(new Point(cordinates[i][0], cordinates[i][1], distSq, i));
        }

        for(int i=0;i<k;i++){
            System.out.print("C"+pq.remove().idx+" ");
        }
    }
}
