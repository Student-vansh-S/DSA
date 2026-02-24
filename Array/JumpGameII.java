public class JumpGameII {
    public static int jump(int[] nums) {
        int jumps = 0;
        int current = 0;
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            j = Math.max(j, i + nums[i]);
            if (i == current) {
                jumps++;
                current = j;
            }
        }
        return jumps;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
