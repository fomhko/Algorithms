class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c : t.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c,1);
            }
            else{
                map.put(c,map.get(c)+1);
            }
        }
        int counter = map.size();
        int end = 0;int start = 0;int len = Integer.MAX_VALUE;int opt_start = 0;
        while(end < s.length()){
            if(counter > 0){
                if(map.containsKey(s.charAt(end))){
                    if(map.get(s.charAt(end)) > 0 && map.get(s.charAt(end)) - 1 == 0){
                        counter--;
                    }

                    map.put(s.charAt(end),map.get(s.charAt(end))-1);

                }
                end++;

            }

            while (counter == 0){
                if(end - start < len){
                    len = end - start;
                    opt_start = start;
                }
                if(map.containsKey(s.charAt(start))){
                    if(map.get(s.charAt(start)) <= 0 && map.get(s.charAt(start))+1 > 0){
                        counter++;
                    }

                    map.put(s.charAt(start),map.get(s.charAt(start))+1);
                }
                start++;
            }
        }
        if(len == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(opt_start,opt_start+len);
    }
}
