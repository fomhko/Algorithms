class Solution {
    public int longestMountain(int[] A) {
        int start = 0;
        int end = 0;
        int peak = 0;
        boolean up = true;
        int max = 0;
        while(end < A.length){
            int next = (end+1) == A.length? Integer.MAX_VALUE:A[end+1];
            if(up == true){
                if(next < A[end]){
                    peak = end;
                    up = false;
                    System.out.println(end + " " + start);

                }
                else if(next == A[end]){
                    start = end+1;
                }
            }
            else{
                System.out.println(end + " " + start);
                if(next >= A[end]){
                    up = true;
                    if(peak != start){
                        max = Math.max(max,end - start+1);
                    }
                    // System.out.println(end + " " + start);
                    if(next == A[end])
                        start = end+1;
                    else
                        start = end;

                }
            }
            end++;
        }

        return max;
    }
}
