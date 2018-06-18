class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        int[] result = new int[numCourses];
        for (int[] i : prerequisites){
            matrix[i[1]][i[0]] = 1;
            inDegree[i[0]] ++;
        }
        int index = 0;
        Queue<Integer> zeroDegree = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                zeroDegree.offer(i);
            }

        }
        while(!zeroDegree.isEmpty()){
            int i = zeroDegree.poll();
            result[index] = i;
            index++;
            for(int j = 0; j < numCourses; j++){
                if(matrix[i][j] != 0){
                    inDegree[j] --;
                    if(inDegree[j] == 0){
                        zeroDegree.offer(j);
                    }
                }
            }
        }
        for(int i : inDegree){
            if(i != 0){
                result = new int[0];
            }
        }
        return result;
    }

}
