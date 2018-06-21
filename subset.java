class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        int num = (int)Math.pow(2,nums.length);
        for(int i = 0; i < num; i++){
            List<Integer> set = new LinkedList<Integer>();
            int ind = i;
            for(int j = 0; j < nums.length;j++){
                if(ind % 2 == 1){
                    set.add(nums[j]);
                }
                ind = ind / 2;
            }
            result.add(set);
        }
        return result;
    }
}
