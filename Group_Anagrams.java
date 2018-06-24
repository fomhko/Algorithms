class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int index = 0;
        HashMap<String,Integer> dict = new HashMap<String,Integer>();
        List<List<String>> result = new LinkedList<List<String>>();
        for(String str : strs){
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
            String temp =new String(sorted);
            if(dict.containsKey(temp)){
                result.get(dict.get(temp)).add(str);
            }
            else{
                dict.put(temp,index);
                result.add(new LinkedList<String>());
                result.get(index).add(str);
                index++;
            }

        }
        return result;
    }
}
