class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();
        for(int c : hand){
            if(tm.get(c) == null){
                tm.put(c,1);
            }
            else{
                tm.put(c,tm.get(c) + 1);
            }
        }
        while(!tm.isEmpty()){
            int head =tm.firstKey();
            for(int i = head; i < head + W;i++){
                if(tm.get(i) == null){
                    return false;
                }
                else{
                    int c = tm.get(i);
                    if(c - 1 == 0){
                        tm.remove(i);
                    }
                    else{
                        tm.put(i,c-1);
                    }
                }
            }
        }
        return true;
    }
}
