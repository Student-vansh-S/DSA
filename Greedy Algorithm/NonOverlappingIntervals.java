import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[1] - b[1]);
        int count = 0;
        int prevs = intervals[0][1];
        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0] < prevs){
                count++;
            }
            else{
                prevs = intervals[i][1];
            }
        }
        return count;
    }
}
