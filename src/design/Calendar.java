package design;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    class Pair {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    ArrayList<Pair> li;

    public Calendar() {
        li = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        if (li.size() == 0) {
            li.add(new Pair(startTime, endTime));
            return true;
        } else if (li.size() == 1) {
            if ((startTime < li.get(0).start && endTime > li.get(0).start)
                    || (startTime < li.get(0).end && endTime > li.get(0).end)) {
                return false;
            }
            if (endTime <= li.get(0).start) {
                li.add(0, new Pair(startTime, endTime));
                return true;
            } else {
                li.add(new Pair(startTime, endTime));
                return true;
            }
        }
        int l = 0;
        int r = li.size() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            Pair before = li.get(m);
            if (startTime >= before.end) {
                if (m == li.size() - 1) {
                    li.add(m + 1, new Pair(startTime, endTime));
                } else {
                    Pair after = li.get(m + 1);
                    if (endTime <= after.start) {
                        li.add(m + 1, new Pair(startTime, endTime));
                    } else {
                        l = m + 1;
                    }
                }
            } else {
                r = m - 1;
            }
        }
        if (r == -1) {
            if ((startTime < li.get(0).start && endTime > li.get(0).start)
                    || (startTime < li.get(0).end && endTime > li.get(0).end)) {
                return false;
            }
            li.add(0, new Pair(startTime, endTime));
            return true;
        }
        if (l == li.size()) {
            if ((startTime < li.get(li.size() - 1).start && endTime > li.get(li.size() - 1).start)
                    || (startTime < li.get(li.size() - 1).end && endTime > li.get(li.size() - 1).end)) {
                return false;
            }
            li.add(new Pair(startTime, endTime));
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        Calendar c = new Calendar();
        System.out.println(c.book(47, 50));
        System.out.println(c.book(33, 41));
        System.out.println(c.book(39, 45));
        System.out.println(c.book(33, 42));
        System.out.println(c.book(25, 32));
        System.out.println(c.book(26, 35));
        System.out.println(c.book(19, 25));
        System.out.println(c.book(3, 8));
        System.out.println(c.book(8, 13));
        System.out.println(c.book(18, 27));

    }

}
