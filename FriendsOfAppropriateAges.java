class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int request = 0;
        int j = 0;
        for(int i = 0; i < ages.length;i++){
            while((j < ages.length) && ((float)ages[i] * 0.5 + 7 >= (float)ages[j])){
                j++;
            }
            if(i > j)
                request += i - j;
        }
        j = 0;
        for (int i = 0; i < ages.length;i++){
            while(ages[j] != ages[i]){
                j++;
            }
            if(ages[i]*0.5+7 < ages[i])
                request += (i-j);
        }

        return request;
    }

}
