class Solution {
    public int numDecodings(String s) {
        func(s,0);
    }
    private int func(String s,int pos){
        if(pos == s.length()-1){
          return 1;
        }
        if(pos >= s.length()){
          return 0;
        }
        int result;
        if(s.charAt(pos) < '2' ||(s.charAt(pos) == '2' && s.charAt(pos+1) <= '6')){
          result += func(pos+2);
        }
        result += func(pos+1);
    }
}
