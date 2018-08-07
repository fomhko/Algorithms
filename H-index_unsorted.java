class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int [] bucket = new int [citations.length+1];
        for(int i : citations){
            if(i >= n){
                bucket[n]++;
            }
            else{
                bucket[i]++;
            }
        }
        int count = 0;
        for(int i = n;i >= 0;i--){
            count += bucket[i];
            if(count >= i){
                return i;
            }
        }
        return 0;

    }
}
    
