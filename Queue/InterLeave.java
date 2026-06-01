import java.util.ArrayDeque;
import java.util.Queue;

public class InterLeave {
    public static void interLeave(Queue<Integer> q){
        Queue<Integer> firstHalf = new ArrayDeque<>();
        int size = q.size();
        for(int i=0; i<size/2;i++){
            firstHalf.add(q.remove());
        }
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        interLeave(q);
        while (!q.isEmpty()) {
            System.out.print(q.remove()+ " ");
        }
    }   
}
