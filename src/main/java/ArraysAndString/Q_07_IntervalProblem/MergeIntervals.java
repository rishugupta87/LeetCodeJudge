package ArraysAndString.Q_07_IntervalProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given  [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {

    /**
     * Tested Leet Code . Self Explanatory
     *
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0) {
            return new ArrayList<Interval>();
        }

        //sort the intervals based on the start point
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval interval1, Interval interval2) {
                if(interval1.start - interval2.start > 0) {
                    return 1;
                } else if(interval1.start - interval2.start < 0) {
                    return -1;
                }
                return 0;
            }
        });

        List<Interval> result = new ArrayList<Interval>();

        //start with the first interval
        Interval prev = intervals.get(0);

        //iterate over the rest of the intervals
        for(int i = 1; i< intervals.size(); i++) {
            Interval curr = intervals.get(i);

            if(prev.end >= curr.start) { //overlap
                Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end));
                prev = merged;
            } else {
                result.add(prev);
                prev = curr;
            }
        }
        //add the last interval
        result.add(prev);

        return result;
    }
}
