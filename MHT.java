class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[][] matrix = new int[n][n];
        int[] visited = new int[n];
        int[] dist = new int[n];
        for (int[] i : edges){
            matrix[i[0]][i[1]] = 1;
            matrix[i[1]][i[0]] = 1;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(0);
        visited[0] = 1;
        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i = 0; i < n; i++){
                if(matrix[tmp][i] == 1 && visited[i] != 1){
                    visited[i] = 1;
                    q.offer(i);
                    dist[i] = dist[tmp] + 1;
                }
            }
        }
        int furthest_nodes = 0;
        int max = 0, maxidx = 0;
        for(int i = 0; i < n;i++){
            if (dist[i] > max){
                max = dist[i];
                maxidx = i;
            }
        }
        //second BFS
        dist[maxidx] = 0;
        q.offer(maxidx);
        visited = null;
        visited = new int[n];
        visited[maxidx] = 1;
        while(!q.isEmpty()){
            int tmp = q.poll();

            for (int i = 0; i < n; i++){
                if(matrix[tmp][i] == 1 && visited[i] != 1){
                    visited[i] = 1;
                    q.offer(i);
                    dist[i] = dist[tmp]+1;
                }
            }
        }
        for (int i : dist)
            System.out.println(i);

        max = 0;
        for(int i = 0; i < n;i++){
            if (dist[i] > max){
                max = dist[i];
            }
        }


        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < n;i++){
            if(max%2!=0){
                if(dist[i] == max/2 || dist[i] == max/2+1){
                    res.add(i);
                }
            }
            else{
                if(dist[i] == max/2){
                    res.add(i);
                }
            }
        }
        return res;
    }
}
