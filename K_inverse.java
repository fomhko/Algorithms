class Solution {
    public int kInversePairs(int n, int k) {
        if(n == 0) {return 0;}
        if(k == 0) {return 1;}
        int mod = 1000000007;
        long [][] dp = new long[n+1][k+1];
        for(int i = 1; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j  = 1; j <= Math.min(k, i*(i-1)/2);j++){
                long p = j-i >=0 ? dp[i-1][j-i] : 0;
                dp[i][j] = (dp[i][j-1] + dp[i-1][j] - p+mod)%mod;
                // for(int p = 0; p < i && j-p >= 0; p++){
                //     dp[i][j] += (dp[i-1][j-p] + mod)%mod;
                // }
            }
        }
        return (int)(dp[n][k]);
    }
}
