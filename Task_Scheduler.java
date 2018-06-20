class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] rec = new int[26];
        for(char i : tasks){
            rec[i - 'A']++;
        }
        int max = Integer.MIN_VALUE;
        for(int i : rec){
            max = Math.max(max,i);
        }
        int count = 0;
        for(int i : rec){
            if (i == max){
                count ++;
            }
        }
        return Math.max(tasks.length,(max-1)*(n+1)+count);
    }
}
