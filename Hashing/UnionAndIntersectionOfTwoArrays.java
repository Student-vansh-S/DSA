import java.util.HashSet;

public class UnionAndIntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1={7,3,9};
        int[] nums2={6,3,9,2,9,4};
        HashSet<Integer> set = new HashSet<>();

        // Union
        for(int num : nums1){
            set.add(num);
        }

        for(int num : nums2){
            set.add(num);
        }

        // System.out.println("Union : "+ set.size());

        // Intersection
        set.clear();
        for(int num : nums1){
            set.add(num);
        }
        int count=0;
        for(int num : nums2){
            if (set.contains(num)) {
                count++;
                set.remove(num);
            }
        }

        System.out.println("Intersection : "+ count );
    }
}
