package math;

public class Sum_of_two_integers{
    public int getSum(int a, int b) {
        int ex = 0;
        int res = 0;
        int carry=0;
        while(a!=0 || b!=0 || carry!=0){
            int d1 = a%2;
            a = a/2;
            int d2 = b%2;
            b = b/2;
            int ans = 0;
            if((d1 + d2 + carry) == 3){
                carry = 1;
                ans = (int)(Math.pow(2,ex) * 1);
            }
            else if ((d1 + d2 + carry) == 2){
                carry = 1;
                ans = 0;
            }
            else{
                
                ans = (int)(Math.pow(2,ex) * (d1 | d2 | carry));
                carry = 0;
            }
            
            res += ans;
            ex++;
        }
        return res;
    }
}