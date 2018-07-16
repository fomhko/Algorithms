
class Solution {
    public int numTrees(int n) {
        int[] rec = new int[n+1];
        rec[1] = 1;
        rec[0] = 1;
        for(int i = 2; i <= n; i++){
            int sum = 0;
            for(int j = 0; j < i;j++){
                sum += rec[j]*rec[i - 1 -j];
            }
            rec[i] = sum;
            System.out.println(sum);
        }
        return rec[n];
    }
}
