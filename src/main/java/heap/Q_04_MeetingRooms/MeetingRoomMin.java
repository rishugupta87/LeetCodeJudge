package heap.Q_04_MeetingRooms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * find the minimum number of conference rooms required.
 *
 For example,
 Given [[0, 30],[5, 10],[15, 20]]
 return 2.
 */
public class MeetingRoomMin {

    // [4,9] [4,17] [9,10]
    public int findMinConfRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start-b.start;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); //keeps track of minimum end time
        int minRooms = 1;

        pq.add(intervals[0].end);

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < pq.peek()) { //the current interval start time is before the previous meetings min finishes
                minRooms++;
            } else { //can reuse the same room, can get rid of previous meetings min end time
                pq.remove();
            }
            pq.add(intervals[i].end);
        }
        return minRooms; //note you dont need to keep this variable, coukd have returned pq.size
    }

    class Interval {
        int start;
        int end;
    }
}
