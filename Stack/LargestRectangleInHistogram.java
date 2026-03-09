import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void largestRectangleArea(int[] arr){
        // Approach 1
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        int[] nSr = new int[arr.length]; // next smallest right
        int[] nSl = new int[arr.length]; // next smallest left

        // next smallest right
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nSr[i] = arr.length;
            } else {
                nSr[i] = s.peek();
            }

            s.push(i);
        }

        // next smallest left
        s = new Stack<>();
        for (int i=0; i<arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nSl[i] = -1;
            } else {
                nSl[i] = s.peek();
            }
            s.push(i);

        }
        // current area -> width = j-i-1 (nsr[i] - nsl[i] -1) 
        for(int i=0; i<arr.length; i++){
            int height = arr[i];
            int width = nSr[i]-nSl[i]-1;
            int currArea = width * height;
            maxArea = Math.max(currArea,maxArea);
        }
        System.out.println("Lagest area of rectangle in histogram : "+maxArea);
        // Approach 2
        // Stack<Integer> stack = new Stack<>();
        // int maxarea = 0, len = heights.length;
        // for(int i = 0; i <= len; i++){
        //     int currh = (i == len) ? 0 : heights[i];
        //     while(!stack.isEmpty() && currh < heights[stack.peek()]){
        //         int height = heights[stack.pop()];
        //         int right = i;
        //         int left = stack.isEmpty() ? -1 : stack.peek();
        //         int width = right - left - 1;
        //         maxarea = Math.max(maxarea, height * width);
        //     }
        //     stack.push(i);
        // }
        // return maxarea;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        largestRectangleArea(arr);
    }
}
