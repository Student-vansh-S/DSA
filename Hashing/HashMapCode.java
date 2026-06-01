import java.util.LinkedList;
import java.util.ArrayList;

public class HashMapCode{
    public static class HashMap<K,V> { // Generic
            private class Node {
                K key;
                V value;
                public Node(K key,V value){
                    this.key = key;
                    this.value= value;
                }
        }
        private int n; // n
        private int N; // buckets.length
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N=4;
            this.buckets = new LinkedList[4];
            for(int i=0;i<4;i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % N; // Because range of buckets is 0 to 3
        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            int di=0;
            for(int i=0;i<ll.size();i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];
            N = 2*N;
            for(int i=0;i<buckets.length;i++){
                buckets[i] = new LinkedList<>();
            }

            // nodes -> add in bucket
            for(int i=0;i<oldBucket.length;i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){ // O(lambda) -> O(1)   
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            if(di!=-1){
                Node node = buckets[bi].get(di);
                node.value = value;
            }
            else{
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double)n/N;
            if(lambda>2.0){
                rehash();
            }

        }

        public boolean containKey(K key){ // O(lambda) -> O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            if(di!=-1){
                return true;
            }
            return false;
        }

        public V remove(K key){ // O(lambda) -> O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            if(di!=-1){
                n--;
                return buckets[bi].remove(di).value;
            }
            return null;
        }

        public V get(K key){ // O(lambda) -> O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            if(di!=-1){
                return buckets[bi].get(di).value;
            }
            return null;
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll = buckets[i];
                for(Node node:ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }
    }
    public static void main(String args[]){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("India",50);
        map.put("Canada",10);
        map.put("China",40);
        map.put("Japan",20);
        // System.out.println(map.remove("Japan"));
        ArrayList<String> keys = map.keySet();
        for(String key:keys){
            System.out.println(key);
        }
    }
}
