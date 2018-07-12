class Solution {
    public String pushDominoes(String dominoes) {
        int len = dominoes.length();
        int[] ldist = new int[len];
        int[] rdist = new int[len];
        int pos = -1;
        for(int i = 0; i < len;i++){
            if(dominoes.charAt(i) == 'R'){
                pos = i;
            }
            if(dominoes.charAt(i) == 'L' && pos != -1){
                pos = -1;
            }
            if(pos == -1){
                rdist[i] = 2*len;
            }
            else{
                rdist[i] = i - pos;
            }
        }
        pos =  -1;
        for(int j = len-1; j >= 0;j--){
            if(dominoes.charAt(j) == 'L'){
                pos = j;
            }
            if(dominoes.charAt(j) == 'R' && pos != -1){
                pos = -1;
            }
            if(pos == -1){
                ldist[j] = 2*len;
            }else{
                ldist[j] = pos - j;
            }
        }

        char[] res = new char[len];
        for(int i = 0; i<len;i++){
            if((ldist[i] > len && rdist[i] > len) || ldist[i] == rdist[i]) {
                res[i] = '.';
            }
            else if(ldist[i] > rdist[i]){
                res[i] = 'R';
            }
            else{
                res[i] = 'L';
            }
        }
        return new String(res);
    }
}
