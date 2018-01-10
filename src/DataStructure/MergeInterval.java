package DataStructure;
import java.util.*;

public class MergeInterval {
    MergeInterval(){}
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }

        //sort the interval
        Collections.sort(intervals, (a,b) -> {
            return a.start - b.start;
        });

        //two pointer, this indicated the previous interval, whihc means the last one will be neglected
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for(Interval interval : intervals) {
            //overlap
            if (interval.start <= end) {
                end = Math.max(interval.end, end);
            } else { // no overlap
                //add the start/ end
                //update start and end
                res.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            }
        }

        //add the last interval to res

        res.add(new Interval(start, end));
        return res;
    }
}
