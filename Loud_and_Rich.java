class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int len = quiet.length;
        int[][] mat = new int[len][len];
        int[] indegree= new int[len];
        for(int i = 0; i < richer.length;i++){
            mat[richer[i][0]][richer[i][1]] = 1;
            indegree[richer[i][1]] += 1;
        }
        Queue<Integer> zeroDegree = new LinkedList<Integer>();
        int min_ind[] = new int[len];
        int min[] = new int[len];
        for(int i = 0; i < len;i++){
            if(indegree[i] == 0){
                zeroDegree.offer(i);
            }
            min[i] = quiet[i];
            min_ind[i] = i;

        }

        while(!zeroDegree.isEmpty()){
            int temp = zeroDegree.poll();
            for(int i = 0; i < len;i++){
                if(mat[temp][i] == 1){
                    min_ind[i] = min[i] < min[temp] ? min_ind[i]:min_ind[temp];
                    min[i] = min[i] < min[temp] ? min[i]:min[temp];
                    indegree[i]--;
                    if(indegree[i] == 0){
                        zeroDegree.offer(i);
                    }
                }
            }
        }
        return min_ind;
    }
}
