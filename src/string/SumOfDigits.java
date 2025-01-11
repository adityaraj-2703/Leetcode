package string;

public class SumOfDigits {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i)-96);
        }
        int sum = 0;
        String temp = sb.toString();
        while(k>0){
            for(int i=0;i<temp.length();i++){
                sum += temp.charAt(i) - '0';
            }
            k--;
            temp = sum + "";
            if(k==0){
                return sum;
            }
            sum = 0;
        }
        return sum;
    }
}
