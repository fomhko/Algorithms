class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == '1'){
                    result ++;
                    System.out.println(i +"," +j);
                    DFS(grid,i,j);
                }
            }
        }
        return result;

    }
    public void DFS(char[][] grid, int i, int j){
        System.out.println("hello");
        grid[i][j] = '2';
        if(i+1 < grid.length && grid[i+1][j] == '1'){DFS(grid,i+1,j);}
        if(i-1 >= 0 && grid[i-1][j] == '1'){DFS(grid,i-1,j);}
        if(j+1 < grid[0].length && grid[i][j+1] == '1'){DFS(grid,i,j+1);}
        if(j-1 >= 0 && grid[i][j-1] =='1'){DFS(grid,i,j-1);}

    }
}
