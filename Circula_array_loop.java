class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0){
                continue;
            }
            int pt1 = i;
            int pt2 = i;
            int count = 0;
            do{
                count++;
                pt1 = (nums[(nums[pt1] + pt1+ nums.length)%nums.length] + nums[pt1] + pt1+2*nums.length)%nums.length;
                pt2 = (nums[pt2] + pt2+nums.length)%nums.length;
            }while(pt1 != pt2 && nums[pt1] > 0 && nums[pt2] > 0);
            if(pt1 == pt2 && (nums [pt1] > 0 && nums[pt2] > 0) && count > 1){
                return true;
            }
            else{
                pt1 = i;
                while(nums[pt1] > 0){
                    int temp = nums[pt1];
                    nums[pt1] = 0;
                    pt1 = (pt1 + temp + nums.length)%nums.length;
                }
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0){
                continue;
            }
            int pt1 = i;
            int pt2 = i;
            int count= 0;
            do{
                count ++;
                pt1 = (nums[(nums[pt1] + pt1+ nums.length)%nums.length] + nums[pt1] + pt1 + 2*nums.length)%nums.length;
                pt2 = (nums[pt2] + pt2+nums.length)%nums.length;
                System.out.println(pt1);
            }while(pt1 != pt2 && nums[pt1] < 0 && nums[pt2] < 0);
            if(pt1 == pt2 && (nums [pt1] < 0 && nums[pt2] < 0) && count > 1){
                return true;
            }
            else{
                pt1 = i;
                while(nums[pt1] < 0){
                    int temp = nums[pt1];
                    nums[pt1] = 0;
                    pt1 = (pt1 + temp + nums.length)%nums.length;
                }
            }
        }
        return false;
    }
}
