class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] hold = new int[prices.length];
        int[] empty = new int [prices.length];
        empty[0] = 0;
        hold[0] = - prices[0];
        hold[1] = Math.max(- prices[1],- prices[0]);
        int i = 2,j = 1;
        while(i < prices.length||j < prices.length){
            if(i < prices.length){
                hold[i] = Math.max(empty[i-2] - prices[i],hold[i-1]);
                i++;
            }
            empty[j] = Math.max(hold[j-1] + prices[j],empty[j-1]);
            j++;
        }
        return empty[prices.length -1];
    }
}
