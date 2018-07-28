class Solution {
    Map<String,PriorityQueue<String>> map =null;
    List<String> result;
    public List<String> findItinerary(String[][] tickets) {
        this.map = new HashMap<String,PriorityQueue<String>>();
        for(String[] t: tickets){
            if(!map.containsKey(t[0])){
                PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>(){
                    public int compare(String s1,String s2){
                        return s1.compareTo(s2);
                    }
                });
                pq.offer(t[1]);
                map.put(t[0],pq);
            }
            else{
                PriorityQueue<String> pq = map.get(t[0]);
                pq.offer(t[1]);
                map.put(t[0],pq);
            }
        }
        this.result = new LinkedList<String>();
        String depart = new String("JFK");

        DFS(depart);
        return result;
    }
    public void DFS(String depart){
        while(map.containsKey(depart)&&!map.get(depart).isEmpty()){
            DFS(map.get(depart).poll());
        }
        result.add(0,depart);
    }
}
