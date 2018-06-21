class Solution {
    public boolean canJump(int[] nums) {
        int index = 0;
        while(index < nums.length-1){
            if(nums[index] == 0){
                break;
            }
            int max = Integer.MIN_VALUE;
            int maxidx = index;
            for (int i = 1;i <= nums[index] && i+index < nums.length;i++){
                if(nums[i+index] > max){
                    max = nums[i+index];
                    maxidx = i+index;
                }
            }
            index = maxidx;
        }
        // System.out.println(nums.length);
        if(index == nums.length - 1){
            return true;
        }
        return false;
    }
}
