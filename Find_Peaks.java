class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(high > low){
            int mid = (high+low)/2;
            int left = mid == 0 ? Integer.MIN_VALUE : nums[mid - 1];
            int right= mid == nums.length-1 ? Integer.MIN_VALUE : nums[mid + 1];
            if(left < nums[mid] && right< nums[mid]){
                high = mid;
                break;
            }
            else if(nums[mid + 1] < nums[mid]){
                high = mid - 1;
            }
            else{
                low = mid  + 1;
            }
        }
        return high;
    }
}
