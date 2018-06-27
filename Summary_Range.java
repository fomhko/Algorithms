class Solution {
    public List<String> summaryRanges(int[] nums) {
        int start = 0;
        int end = 0;
        List<String> result = new LinkedList<String>();
        if(nums.length == 0){return result;}
        for(int i = 1; i < nums.length;i++){
            if(nums[i] == nums[i-1]+1){
                end++;
            }
            else{
                if(start == end){
                    result.add(String.format("%d",nums[start]));
                }
                else{
                    result.add(String.format("%d->%d",nums[start],nums[end]));
                }
                start = i;
                end = i;
            }
        }
        if(start == end){
                    result.add(String.format("%d",nums[start]));
                }
                else{
                    result.add(String.format("%d->%d",nums[start],nums[end]));
                }
        return result;

    }
}
