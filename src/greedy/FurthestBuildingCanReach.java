package greedy;

public class FurthestBuildingCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] <= heights[i - 1]) {
                continue;
            } else {
                if (bricks == 0 && ladders == 0) {
                    return i - 1;
                }
                if (heights[i] - heights[i - 1] <= bricks) {
                    bricks -= heights[i] - heights[i - 1];
                } else {
                    ladders--;
                }
            }

        }
        return heights.length;
    }

    public static void main(String[] args) {
        int[] heights = { 4, 2, 7, 6, 9, 14, 12 };
        int bricks = 5;
        int ladders = 1;
        FurthestBuildingCanReach f = new FurthestBuildingCanReach();
        System.out.println(f.furthestBuilding(heights, bricks, ladders));
    }

}
