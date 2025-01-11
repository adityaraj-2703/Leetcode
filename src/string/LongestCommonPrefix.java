package string;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] A) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<A.length;i++){
            sb.append(A[i] + "$");
        }
        int[] z = zAlgo(sb.toString());
        int max = Integer.MIN_VALUE;
        for(int i=0;i<z.length;i++){
            max = Math.max(z[i],max);
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<max;i++){
            ans.append(A[0].charAt(i));
        }
        return ans.toString();
    }
    static int[] zAlgo(String s){
        int[] z = new int[s.length()];
        int n = s.length();
        int l = 0;
        int r = 0;
        for(int i=1;i<s.length();i++){
            if(i>r){
                int p1 = 0;
                r = i;
                l = i;
                while(r<n && s.charAt(r)==s.charAt(p1)){
                    p1++;
                    r++;
                }
                r--;
                z[i] = r-l+1;
            }
            else{
                int j = i-l;
                if(z[j] < r-i+1){
                    z[i] = z[j];
                }
                else{
                    l=i;
                    r = r+1;
                    int p1 = i-l+1;
                    while(r<n && s.charAt(i) == s.charAt(p1)){
                        r++;
                        p1++;
                    }
                    r--;
                    z[i] = r-l+1;
                }
            }
        }
        return z;
    }
}
