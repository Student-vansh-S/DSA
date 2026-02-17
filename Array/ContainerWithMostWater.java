import java.util.*;
public class ContainerWithMostWater {
    public static int maxWaterArea(int[] height) {
        int maxWater=0;
        int currWater=0;
        int left=0;
        int right=height.length-1;

        // Brute Force
        // for(int i=0;i<height.length;i++){
        //     for(int j=i+1;j<height.length;j++){
        //         int ht=Math.min(height[i],height[j]);
        //         int width=j-i;
        //         currWater=ht*width;
        //         maxWater=Math.max(currWater, maxWater);
        //     }
        // }

        //2 Pointer approach TC-O(n) and SC-O(1)
        // while(left<right){
        //     int ht=Math.min(height[left],height[right]);
        //     int width=right-left;
        //     int currWater=ht*width;
        //     maxWater=Math.max(currWater,maxWater);
        //     if(height[left]<height[right]) left++;
        //     else{
        //         right--;
        //     }
        // }

        // 2 Pointer approach with little fast due to fewer function calls and direct computation, TC-O(n) and SC-O(1)
        while(left < right){
            if(height[left]<height[right]){
                currWater= height[left] * (right-left);
                maxWater=Math.max(currWater,maxWater);
                left++;
            }else{
                currWater= height[right] * (right-left);
                maxWater=Math.max(currWater,maxWater);
                right--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("Area of Water :"+maxWaterArea(height));
    }
}
