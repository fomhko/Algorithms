class Solution {
    public int numSquares(int n) {
        int [] rec = new int[n+1];
        rec[1] = 1;
        for(int i = 2; i <= n;i++){
            rec[i] = Integer.MAX_VALUE;
            for(int j = 1; j*j <= i;j++){
                rec[i] = Math.min(rec[i],1+rec[i-j*j]);
            }
        }
        return rec[n];
    }
}
