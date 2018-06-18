class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] matrix = new boolean[p.length() + 1][s.length() + 1];
        matrix[0][0] = true;
        if(p.length() != 0 && p.charAt(0) == '*'){
            for(int i = 1;i < p.length()+1;i++){
                matrix[i][0] = matrix[i-1][0] && (p.charAt(i-1) == '*');
            }
        }
        for(int i = 1; i < p.length() + 1; i ++){
            for(int j = 1; j < s.length() + 1;j++){
                int ii = i-1;
                int jj = j-1;
                if(p.charAt(ii) == '*'){
                    int tmp = 1;
                    if(ii == 0){tmp = 0;}
                    for(int k = tmp; k <= j;k++){
                        if(matrix[i-1][k] == true){
                            matrix[i][j] = true;
                            break;
                        }
                    }
                }
                else if (p.charAt(ii) == '?' || p.charAt(ii) == s.charAt(jj)){
                    matrix[i][j] = matrix[i-1][j-1];
                }
            }
        }
        // for(int i = 0; i < p.length()+1; i++){
        //     String str = "";
        //     for(int j = 0; j < s.length()+1; j++){
        //         str = str + matrix[i][j];
        //     }
        //     System.out.println(str);
        // }
        return matrix[p.length()][s.length()];
    }
}
