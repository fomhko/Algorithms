class Solution {
    public int numDecodings(String s) {
        func(s,0);
    }
    public int func(String s,int pos){
        if(pos == s.length()-1){
          return 1;
        }
        if(pos >= s.length()){
          return 0;
        }
        int result;
        if(s.charAt(i) < '2' ||(s.charAt(i) == '2' && s.charAt(i+1) <= '6')){
          result += func(i+2);
        }
        result += func(i+1);
    }
}
