class Solution {
    public int matrixScore(int[][] A) {
        for(int i = 0; i < A.length; i++){
            if(A[i][0] == 0){
                for(int j = 0;j < A[0].length;j++){
                    A[i][j] = 1 - A[i][j];
                }
            }
        }
        int result = 0;
        for(int i = 0; i < A[0].length;i++){
            int count = 0;
            for (int j = 0; j < A.length;j++){
                if(A[j][i] == 1) count++;
            }
            count = Math.max(A.length-count, count);
            result += Math.pow(2,A[0].length - 1 - i) * count;
        }
        return result;
    }
}
