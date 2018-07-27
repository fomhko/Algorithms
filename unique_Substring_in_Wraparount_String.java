class Solution {
    public int findSubstringInWraproundString(String p) {
        if(p.length()==0){
            return 0;
        }
        int count[] = new int [26];
        int length = 1;
        count[(p.charAt(0) - 'a')] = 1;
        for(int i = 1; i < p.length(); i++){
            if((int)(p.charAt(i)-'a') == ((int)(p.charAt(i-1)-'a')+1) % 26){
                length++;
            }
            else{
                length = 1;
            }
            count[p.charAt(i) - 'a'] = Math.max(count[p.charAt(i) - 'a'],length);
        }
        int result = 0;
        for(int i = 0; i < 26;i++){
            result += count[i];
        }
        return result;
    }
}
