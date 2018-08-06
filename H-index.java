class Solution {
    public int hIndex(int[] citations) {
        int low = 1;
        int high = citations.length;
        int N = citations.length;
        boolean all_zero = true;
        for(int i: citations){
            if(i!=0){all_zero = false;}
        }
        if(all_zero){return 0;}
        while(high > low){
            int mid = (high + low)/2;
            if(citations[N-mid]>=mid){
                if(N-mid == 0 || (N-mid-1 >= 0 && citations[N-mid-1] <= mid)){
                    return mid;
                }
                else{
                    // System.out.println(mid);/
                    low = mid + 1;
                }
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
}
