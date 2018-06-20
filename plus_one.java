class Solution {
    public int[] plusOne(int[] digits) {
        int co = 0;
        int end = digits.length-1;
        for(int i = end;i >= 0;i--){
            if(i == end){
                co = (digits[i] + 1)/10;
                digits[i] = (digits[i]+1)%10;
            }
            else {
                int tmp = co;
                co = (co+digits[i])/10;
                digits[i] = (digits[i] + tmp)%10;
            }
        }
        if(co != 0){
            int[] res = new int[digits.length+1];
                res[0] = 1;
                for(int i = 1; i < res.length;i++){
                    res[i] = digits[i-1];
                }
            return res;
        }
        else {
            return digits;
        }
    }
}
