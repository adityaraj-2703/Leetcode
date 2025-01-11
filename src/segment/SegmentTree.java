package segment;

public class SegmentTree {
    int[][] segmentTree;
    int n;
    public SegmentTree(int[] nums) {
        segmentTree = new int[4*nums.length][3];
        this.n = nums.length;
        buildSegmentTree(0,nums,0,nums.length-1);
    }
    public void buildSegmentTree(int i,int[] nums,int l,int r){
        if(l==r){
            segmentTree[i][0] = l;
            segmentTree[i][1] = r;
            segmentTree[i][2] = nums[l];
            return;
        }
        int m = l + (r-l)/2;
        buildSegmentTree(2*i+1,nums,l,m);
        buildSegmentTree(2*i+2,nums,m+1,r);
        segmentTree[i][0] = l;
        segmentTree[i][1] = r;
        segmentTree[i][2] = segmentTree[2*i+1][2] + segmentTree[2*i+2][2];
        
    }
    public int[][] getSegmentTree(){
        return this.segmentTree;
    }
    
    public void update(int index, int val) {
        updateHelper(1, 0, n - 1, index, val);
    }

    private void updateHelper(int pos, int start, int end, int idx, int val){
        if(start == end){
            segmentTree[pos][2] = val;
            return;
        }
        
        int mid = start + (end - start) / 2;
        if(idx <= mid)
            updateHelper(2 * pos, start, mid, idx, val);
        else 
            updateHelper(2 * pos + 1, mid + 1, end, idx, val);
        segmentTree[pos][2] = segmentTree[2 * pos][2] + segmentTree[2 * pos + 1][2]; 
    }
    
    public int sumRange(int left, int right) {
        
        return sumRangeUtil(0,0,n-1,left,right);
        
    }
    public int sumRangeUtil(int pos,int l,int r,int ql,int qr){
        if(l >= ql && r <= qr)
            return segmentTree[pos][2];
        
        if(r < ql || l > qr)
            return 0;
        
        int m = l + (r-l)/2;
        int left = sumRangeUtil(2*pos+1,l,m,ql,qr);
        int right = sumRangeUtil(2*pos+2,m+1,r,ql,qr);
        return left + right;
    }
}
