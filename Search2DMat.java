class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0|| matrix[0].length == 0) return false;
        boolean[] row = new boolean [matrix.length];
        boolean[] col = new boolean [matrix[0].length];
        for(int i = 0; i < matrix.length ;i++){
            for(int j = 1 ; j < matrix[0].length;j++){
                if(matrix[i][j] < matrix[i][j-1]){
                    row[i] = true;
                    break;
                }
            }
        }
        for(int i = 0; i < matrix[0].length; i++){
            for(int j = 1; j < matrix.length;j++){
                if(matrix[j][i] < matrix[j-1][i]){
                    col[i] = true;
                    break;
                }
            }
        }
        for(int i = 0; i < matrix.length;i++){
            for(int j = 0; j < matrix[0].length;j++){
                if(matrix[i][j] == target && !row[i] && !col[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
