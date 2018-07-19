class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int[][] B_ind = new int[B.length][2];
        for(int i = 0; i < B.length; i++){
            B_ind[i][0] = B[i];
            B_ind[i][1] = i;
        }
        Arrays.sort(B_ind,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0] - b[0];
            }
        });
        Arrays.sort(A);
        int A_low = 0; int A_high = A.length - 1;
        int B_low = 0; int B_high = B.length - 1;
        int [] result = new int[B.length];
        while(A_low <= A_high){
            if(A[A_high] > B_ind[B_high][0]){
                result[B_ind[B_high][1]] = A[A_high];
                A_high --;
                B_high --;
            }
            else{
                result[B_ind[B_high][1]] = A[A_low];
                A_low++;
                B_high--;
            }
        }
        return result;
    }
}
