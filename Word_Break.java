class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<String>();
        for (String i : wordDict){
            dict.add(i);
        }
        boolean[] seg = new boolean[s.length()];
        for(int i = 0; i < s.length();i++){

            for(int j = 0; j < i; j++){
                if(seg[j] && dict.contains(s.substring(j+1,i+1))){
                    seg[i] = true;
                    break;
                }
            }
            if(dict.contains(s.substring(0,i+1))){
                seg[i] = true;
            }
            System.out.println(""+seg[i]);
        }
        return seg[s.length() -1];
    }

}
