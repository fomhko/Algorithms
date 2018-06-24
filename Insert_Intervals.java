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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int merge_start = newInterval.start;
        int merge_end = newInterval.end ;
        List<Interval> result = new LinkedList<Interval>();
        if(intervals.size() == 0){
            result.add(newInterval);
            return result;
        }
        for (Interval interval:intervals){
            if(isOverlap(interval,newInterval)){
                merge_start = Math.min(merge_start,interval.start);
                merge_end = Math.max(merge_end,interval.end);
            }
            else{
                result.add(interval);
            }
        }
        for(int i = 0; i <= result.size();i++){
            if(i == result.size() || result.get(i).start > merge_start ){
                result.add(i,new Interval(merge_start,merge_end));
                break;
            }
        }
        return result;
    }
    public boolean isOverlap(Interval a,Interval b){
        if(a.start>b.end || a.end < b.start){
            return false;
        }
        else
            return true;
    }
}
