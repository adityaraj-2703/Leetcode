package string;

public class LongestCommonPrefix1 {
    public String longestCommonPrefix(String[] A) {
        String a = A[0];
        int c1 = 0;
        
        for(int i=1;i<A.length;i++){
            int counter=0;
            for(int j=0;j<=A[i].length();j++){
                
                
                if(j>=a.length() || j >= A[i].length() || a.charAt(j)!=A[i].charAt(j)){
                    c1 = counter;
                    counter=0;
                    break;
                }
                else{
                    counter++;
                }
            }
            a = a.substring(0,c1);
            c1=0;
        }
        return a;
    }
}
