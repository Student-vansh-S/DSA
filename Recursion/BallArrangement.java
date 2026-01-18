public class BallArrangement {
    
    static void findArrangements(char[] balls, boolean[] used, String current) {
        if (current.length() == balls.length) {
            System.out.println(current);
            return;
        }

        for (int i = 0; i < balls.length; i++) {
            if (!used[i]) {
                used[i] = true;
                findArrangements(balls, used, current + balls[i]);
                used[i] = false; // backtracking
            }
        }
    }
    public static void main(String[] args) {
        char[] balls = {'G', 'Y', 'R'};
        boolean[] used = new boolean[3];

        findArrangements(balls, used, "");
    }
}

