import java.util.Stack;

public class TrappingRainWater {
    public static int trappingRainWater(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int waterTrapped = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            // Jab tak current bar bada hai stack ke top se, puddle banega
            while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
                int mid = s.pop(); // Woh jagah jahan pani bharega (bottom)

                if (s.isEmpty()) break; // Left boundary nahi mili

                int left = s.peek(); // Left Boundary ka index
                int right = i;       // Right Boundary ka index

                // Height: Dono boundaries mein se choti height - bottom bar ki height
                int h = Math.min(arr[left], arr[right]) - arr[mid];

                // Width: Dono boundaries ke beech ki distance
                int w = right - left - 1;

                waterTrapped += h * w;
            }
            s.push(i);
        }
        return waterTrapped;
    }

    public static void main(String[] args) {
        int arr[] = {7, 0, 4, 2, 5, 0, 6, 4, 0, 6};
        System.out.println("Water Trapped using Stack: " + trappingRainWater(arr));
    }
}