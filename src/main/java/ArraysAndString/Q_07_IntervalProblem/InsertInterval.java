package ArraysAndString.Q_07_IntervalProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {

    /**
     * Tested LeetCode.
     * Note in this question we jst need to merge the newInterval if there is an overlap
     * Do not merge the rest of the intervals even if they overlap.
     *
     *
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> result = new ArrayList<Interval>();
        for (Interval currInterval : intervals) {
            if (newInterval == null || currInterval.end < newInterval.start) //newInterval is after the current interval or if we already have added newInterval, add the currInterval
                result.add(currInterval);
            else if (currInterval.start > newInterval.end) { // if newInterval is before the currInterval, add current and newInterval, mark newInterval as null as you already added it
                result.add(newInterval);
                result.add(currInterval);
                newInterval = null;
            } else { //overlap
                newInterval.start = Math.min(newInterval.start, currInterval.start);
                newInterval.end = Math.max(newInterval.end, currInterval.end);
            }
        }
        if (newInterval != null)
            result.add(newInterval);
        return result;
    }

    public static void main(String[] args) {
//        List<Interval> intervals1 = new ArrayList<Interval>(Arrays.asList(new Interval(1,3), new Interval(6, 9)));
//        Interval newInterval1 = new Interval(2, 5);
//        insert(intervals1, newInterval1);

        List<Interval> intervals1 = new ArrayList<Interval>(Arrays.asList(new Interval(1,5), new Interval(2, 5)));
        Interval newInterval1 = new Interval(6, 9);
        insert(intervals1, newInterval1);

//        List<Interval> intervals2 = new ArrayList<Interval>(Arrays.asList(new Interval(1,2), new Interval(3, 5), new Interval(6, 7), new Interval(8, 10), new Interval(12, 16)));
//        Interval newInterval2 = new Interval(4, 9);
//        insert(intervals2, newInterval2);
    }
}
