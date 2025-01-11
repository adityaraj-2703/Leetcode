package linkedelist;

public class HappyNumber {
    public boolean isHappy(int n) {
        int slow = 0;
        int fast = 1;
        while(slow != fast){
            slow = square(n);
            fast = square(square(n));
            n = slow;
            slow = fast;
            fast = square(square(fast));
            
        }
        if(slow==fast && slow==1){
                return true;
        }
        else if(slow==fast && slow!=1){
                return false;
        }
        return false;
        
    }
    static int square(int num){
        int temp = num;
        int sum=0;
        while(temp>0){
            int rem = temp%10;
            sum += rem*rem;
            temp /= 10;
        }
        return sum;
    }
}
