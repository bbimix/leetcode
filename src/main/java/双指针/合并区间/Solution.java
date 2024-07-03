package 双指针.合并区间;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // write code here
        if (intervals.size() == 0) {
            return new ArrayList<Interval>();
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });

        ArrayList<Interval> res = new ArrayList<>();
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval origin = intervals.get(i);
            Interval result = res.get(res.size() - 1);
            if (origin.start > result.end) {
                res.add(origin);
            } else {
                res.remove(res.size() - 1);
                Interval temp = new Interval(result.start, Math.max(result.end, origin.end));
                res.add(temp);
            }
        }
        return res;
    }
}
