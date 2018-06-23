/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<Interval>();
        if(intervals.size() == 0){
            return result;
        }
        intervals.sort(new Comparator<Interval>(){
                public int compare(Interval a, Interval b){
                    return a.start-b.start;
                }
            });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for(Interval iter : intervals){
            if(iter.start<=end){
                end = Math.max(end,iter.end);
            }
            else{
                result.add(new Interval(start,end));
                start=iter.start;
                end = iter.end;
            }
        }
        result.add(new Interval(start,end));
        return result;

    }
}
