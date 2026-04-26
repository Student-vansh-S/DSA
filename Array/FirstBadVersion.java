public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (isBadVersion(mid)) {
                end = mid; // go left
            } else {
                start = mid + 1; // go right
            }
        }

        return start;
    }
}
