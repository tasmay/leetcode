import java.util.*;
import java.util.LinkedList;

public class MeetingRooms {

    public static boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (Interval a, Interval b) -> a.start-b.start);
        int prevEnd = intervals.get(0).end;
        for(int i=1; i < intervals.size(); i++) {
            if(intervals.get(i).start < prevEnd)
                return false;
            else {
                prevEnd = intervals.get(i).end;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new LinkedList<>();
        //intervals.add(new Interval(0,30));
        //intervals.add(new Interval(5,10));
        //intervals.add(new Interval(15,20));
        intervals.add(new Interval(5,8));
        intervals.add(new Interval(9,15));
        System.out.println(canAttendMeetings(intervals));
    }
}
