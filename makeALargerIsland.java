class Solution {
    public int largestIsland(int[][] grid) {
        int[][] markerGrid = new int[grid.length][grid[0].length];
        int marker = 1;
        int result = 0;
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int size = counterDFS(grid,i,j);
                    markerDFS(markerGrid,grid,i,j,size,marker);
                    marker++;
                    result = Math.max(result,size);
                }
            }
        }
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    int[] neighbour = new int[4];
                    int[] mark = new int[4];
                    neighbour[0] = i-1 >= 0 ? grid[i-1][j]:0;mark[0] = i-1 >= 0 ? markerGrid[i-1][j]:0;
                    neighbour[1] = i+1 < grid.length ? grid[i+1][j]:0;mark[1] = i+1 < grid.length ? markerGrid[i+1][j]:0;
                    neighbour[2] = j-1 >= 0 ? grid[i][j-1]:0;mark[2] = j-1 >= 0 ? markerGrid[i][j-1]:0;
                    neighbour[3] = j+1 <grid[0].length ? grid[i][j+1]:0;mark[3] = j+1 <grid[0].length ? markerGrid[i][j+1]:0;
                    HashSet<Integer> hs = new HashSet<Integer>();
                    int temp = 0;
                    for(int a = 0; a < 4; a++){
                        if(!hs.contains(mark[a])){
                            hs.add(mark[a]);
                            temp+=neighbour[a];
                        }
                    }
                    result = Math.max(result,temp+1);
                }
            }
        }
        if(result == 0){result ++;}
        return result;
    }
    public int counterDFS(int[][] grid,int i, int j){
        int result = 0;
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == -1 || grid[i][j] == 0){
            return result;
        }
        grid[i][j] = -1;
        result += counterDFS(grid,i+1,j);
        result += counterDFS(grid,i-1,j);
        result += counterDFS(grid,i,j+1);
        result += counterDFS(grid,i,j-1);
        result ++;
        return result;
    }
    public void markerDFS(int[][] markerGrid,int[][] grid, int i, int j,int size,int marker){
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] != -1 || grid[i][j] == 0){
            return;
        }
        grid[i][j] = size;
        markerGrid[i][j] = marker;
        markerDFS(markerGrid,grid,i+1,j,size,marker);
        markerDFS(markerGrid,grid,i-1,j,size,marker);
        markerDFS(markerGrid,grid,i,j+1,size,marker);
        markerDFS(markerGrid,grid,i,j-1,size,marker);
    }
}
