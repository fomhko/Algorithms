class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min_gas = 0;
        int min_ind = gas.length-1;
        for(int i = 0; i < gas.length; i++){
            sum += (gas[i] - cost[i]);
            if(sum < min_gas){
                min_gas = sum;
                min_ind = i;
            }
        }
        int j = (min_ind + 1) % gas.length;

        sum = 0;
        for(int i = 0; i < gas.length; i++){
            sum += gas[j] - cost[j];
            if(sum < 0){
                return - 1;
            }
            j = (j+1)%gas.length;
        }
        return (min_ind+1)%gas.length;
    }

}
