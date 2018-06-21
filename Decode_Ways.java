class Solution {
    public int numDecodings(String s) {
        return func(s,0);
    }
    private int func(String s,int pos){
        if(s.length() == 0){
            return 0;
        }
        if(pos >= s.length()-1){
            if(pos == s.length() - 1 && s.charAt(pos) == '0'){
                return 0;
            }
            return 1;
        }
        if(s.charAt(pos) == '0'){
            return 0;
        }
        int result = 0;
        if((s.charAt(pos) < '2' ||(s.charAt(pos) == '2' && s.charAt(pos+1) <= '6')) && s.charAt(pos) > '0'){
          result += func(s,pos+2);
        }
        result += func(s,pos+1);
        return result;
    }
}
