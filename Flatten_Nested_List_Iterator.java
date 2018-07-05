/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack <NestedInteger> s = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >=0; i--){
            s.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return (s.pop().getInteger());
    }

    @Override
    public boolean hasNext() {
        if(s.empty()){
            return false;
        }
        else{
                while(!s.peek().isInteger()){
                    List<NestedInteger> temp = s.pop().getList();
                    if(temp.size()>0){
                        for(int i = temp.size() - 1; i >= 0; i--){
                            s.push(temp.get(i));
                        }
                    }
                    if(s.empty()) return false;
                }
            }
            return true;
        }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
