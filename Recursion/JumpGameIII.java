public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }
    private boolean dfs(int[] arr, int start, boolean[] visited) {
        // out of bounds
        if (start < 0 || start >= arr.length) {
            return false;
        }
        // already visited
        if (visited[start]) {
            return false;
        }
        // reached zero
        if (arr[start] == 0) {
            return true;
        }
        visited[start] = true;
        // jump forward OR backward
        return dfs(arr, start + arr[start], visited) || dfs(arr, start - arr[start], visited);
    }
}