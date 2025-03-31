package segment;

public class SegmentTree {
    int[] seg;
    int length;

    public SegmentTree(int[] nums) {
        seg = new int[nums.length * 4];
        length = nums.length;
        buildSegmentTree(nums, 0, 0, nums.length - 1);
    }

    public void buildSegmentTree(int[] nums, int ind, int low, int high) {
        if (low == high) {
            seg[ind] = nums[low];
            return;
        }
        int m = (low + high) / 2;
        buildSegmentTree(nums, 2 * ind + 1, low, m);
        buildSegmentTree(nums, 2 * ind + 2, m + 1, high);
        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
    }

    public int sumRange(int left, int right, int ind, int low, int high) {
        if (left > high || right < low) {
            return 0;
        }
        if (low >= left && high <= right) {
            return seg[ind];
        }
        int mid = (low + high) / 2;
        int l = sumRange(left, right, 2 * ind + 1, low, mid);
        int r = sumRange(left, right, 2 * ind + 1, low, mid);
        return l + r;
    }

    public void update(int index, int ind, int val, int low, int high) {
        if (low == high) {
            seg[ind] = val;
            return;
        }
        int mid = (low + high) / 2;
        if (index <= mid) {
            update(index, 2 * ind + 1, val, low, mid);
        } else {
            update(index, 2 * ind + 2, val, mid + 1, high);
        }
        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
    }

    public void update(int index, int val) {
        update(index, 0, val, 0, length - 1);
    }

    public int sumRange(int left, int right) {
        return sumRange(left, right, 0, 0, length - 1);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5 };
        SegmentTree s = new SegmentTree(nums);
        System.out.println(s.sumRange(0, 2));
        s.update(1, 2);
        System.out.println(s.sumRange(0, 2));
    }

}
