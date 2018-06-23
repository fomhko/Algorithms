class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] matrix = new int[s.length()][s.length()];
        for(int i = 0; i < s.length();i++){
            matrix[i][i] = 1;
        }
        for(int i = s.length()-1; i >= 0;i--){
            for(int j = i+1; j < s.length();j++){
                matrix[i][j] = Math.max(matrix[i+1][j],matrix[i][j-1]);
                if(s.charAt(i) == s.charAt(j)){
                    matrix[i][j] = Math.max(matrix[i][j],matrix[i+1][j-1] + 2);
                }
            }
        }
        return matrix[0][s.length()-1];
    }
}
