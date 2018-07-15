class Solution {
    public int uniqueLetterString(String S) {
        int[] lastpos = new int[26];
        int[] alive = new int[26];
        int[] result = new int[S.length()];
        for(int i=0; i < 26;i++){
            lastpos[i] = -1;
        }
        for(int i=0; i < S.length();i++){
            result[i] = i==0? 1 : result[i-1]- alive[(int)(S.charAt(i) - 'A')]+i-lastpos[(int)(S.charAt(i) - 'A')];
            alive[(int)(S.charAt(i) - 'A')] = i - lastpos[(int)(S.charAt(i) - 'A')];
            // System.out.prinln(S.charAt(i) - 'A');
            lastpos[S.charAt(i) - 'A'] = i;
        }
        int ret = 0;
        for(int i = 0; i < S.length(); i++){
            ret += result[i];
        }
        return ret;
    }
}
