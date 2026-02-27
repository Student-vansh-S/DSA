public class ShortestPath {
    public static float getShortestPath(String path,int x,int y){
        int X2=0,Y2=0;
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='N'||path.charAt(i)=='n'){
                y+=1;
            }
            else if(path.charAt(i)=='s'||path.charAt(i)=='S'){
                y-=1;
            }
            else if(path.charAt(i)=='W'|| path.charAt(i)=='w'){
                x-=1;
            }
            else{
                x+=1;
            }
        }
        X2=x*x;
        Y2=y*y;
        return (float)Math.sqrt(X2+Y2);
    }
    public static void main(String[] args) {
        int x=0,y=0;
        String path="WNEENESENNN";
        System.out.println(getShortestPath(path, x, y));
    }
}
