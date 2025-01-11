package string;

public class MovePiecesToObtainAString {
    public boolean canChange(String start, String target) {
        int i=0;
        int j=0;
        int ind = -1;
        int m = start.length();
        int n = target.length();
        while(i<m && j<n){
            while(i<m && start.charAt(i)=='_'){
                i++;
            }
            while(j<n && target.charAt(j)=='_'){
                j++;
            }
            if(i==m && j==n){
                return true;
            }
            if(start.charAt(i)!=target.charAt(j)){
                return false;
            }
            if(start.charAt(i)=='L'){
                if(j<=ind || j>i){
                    return false;
                }
            }
            else if(start.charAt(i)=='R'){
                if(i>j){
                    return false;
                }
            }
            ind = j;
            i++;
            j++;
        }
        while(i<m && start.charAt(i)=='_'){
            i++;
        }
        while(j<n && target.charAt(j)=='_'){
            j++;
        }
        return i==m && j==n;
    }
}
