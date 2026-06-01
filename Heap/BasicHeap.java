import java.util.ArrayList;

public class BasicHeap {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){
            //add at last idx
            arr.add(data);
            int x = arr.size()-1; // x is child index
            int parent = (x-1)/2; // parent index
            while (x > 0 && arr.get(x) < arr.get(parent)) {
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);

                x = parent;
                parent = (x-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if (minIdx!=i) {
                //Swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx);
            }
        }
        
        public int remove(){
            int data = arr.get(0);

            //Step 1: Swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //Step 2: Delete Last Element
            arr.remove(arr.size()-1);

            //Step 3: heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(2);
        h.add(5);
        h.add(1);
        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
