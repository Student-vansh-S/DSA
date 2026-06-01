import java.util.*;
public class ClassRoom {
    static class Student implements Comparable<Student> { // overriding
        String name;
        int rank;
        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }
    public static void main(String args[]){
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("A", 4)); // O(n)
        pq.add(new Student("B", 3)); // O(n)
        pq.add(new Student("C", 1)); // O(n)
        pq.add(new Student("D", 2)); // O(n)

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + "->"+pq.peek().rank); // O(1)
            pq.remove(); //O(logn)
        }
    }
}

