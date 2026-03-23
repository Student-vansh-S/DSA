import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JobSequencingProblem {
    static class job {
        int deadline;
        int profit;
        int id;
        public job(int i,int d,int p){
            id=i;
            deadline=d;
            profit=p;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        job jobs[] = new job[n];
        for(int i=0;i<n;i++){
            jobs[i] = new job(i, endTime[i], profit[i]);
        }
        Arrays.sort(jobs, (obj1,obj2) -> obj2.profit-obj1.profit); // desecding order of profit
        int time = 0;
        int maxProfit = 0;
        for(int i=0;i<jobs.length;i++){
            job curr= jobs[i];
            if(curr.deadline > time){
                maxProfit += curr.profit;
                time++;
            }
        }
        return maxProfit;
    }
    public static void main(String args[]){
        int jobsInfo[][] = {{4,20},{1,10},{1,40},{1,30}};
        ArrayList<job> jobs = new ArrayList<>();
        for(int i=0;i<jobsInfo.length;i++){
            jobs.add(new job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }
        
        Collections.sort(jobs, (obj1,obj2) -> obj2.profit-obj1.profit); // desecding order of profit
        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i=0;i<jobs.size();i++){
            job curr= jobs.get(i);
            if(curr.deadline > time){
                seq.add(curr.id);
                time++;
            }
        }

        //print seq
        System.out.println("Max jobs = "+seq.size());
        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
        }
    }
}
