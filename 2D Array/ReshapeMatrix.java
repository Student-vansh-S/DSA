public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n=mat.length;
        int m=mat[0].length;
        if(m*n!=r*c) return mat;
        int idx=0,i2=0;
        int ans[][]=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ans[i][j]=mat[idx][i2];
                i2++;
                if(i2==m) {
                    i2=0;
                    idx++;
                }
            }
        }
        return ans;
        
    }
}
