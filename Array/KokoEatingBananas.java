public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int minSpeed=1;
        int maxSpeed=0;
        //Find max pile size
        for(int pile:piles){
            maxSpeed=Math.max(maxSpeed,pile);
        }
        //Binary Search
        while(minSpeed<maxSpeed){
            int mid = minSpeed+(maxSpeed-minSpeed)/2;
            if(requiredHours(piles,mid)<=h){
                maxSpeed = mid;
            }else{
                minSpeed=mid+1;
            }
        }
        return minSpeed;
    }
    public static long requiredHours(int[] piles, int speed) {
        long hours = 0;
        for (int p : piles) {
            hours += (p + speed - 1) / speed;
        }
        return hours;
    }
    public static void main(String[] args) {
        int[] piles={3,6,7,11};
        int hours=8;
        System.out.println("Koko can eat minimum "+minEatingSpeed(piles, hours)+" bananas per hour with in "+hours+" hours.");
    }
}
