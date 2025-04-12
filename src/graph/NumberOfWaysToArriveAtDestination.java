package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination {

    public int countPaths(int n, int[][] roads) {

        return 0;

    }

    public static void main(String[] args) {
        NumberOfWaysToArriveAtDestination n = new NumberOfWaysToArriveAtDestination();
        int[][] roads = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 }, { 3, 5, 1 }, { 6, 5, 1 },
                { 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };
        System.out.println(n.countPaths(7, roads));
    }

}
