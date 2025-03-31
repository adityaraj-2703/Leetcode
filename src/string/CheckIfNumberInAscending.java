package string;

public class CheckIfNumberInAscending {
    public boolean areNumbersAscending(String s) {
        int ind = 0;
        int prev = 0;
        while (ind < s.length()) {
            if (Character.isDigit(s.charAt(ind))) {
                int val = 0;
                while (ind < s.length() && Character.isDigit(s.charAt(ind))) {
                    val = val * 10 + (s.charAt(ind) - '0');
                    ind++;
                }
                if (val <= prev) {
                    return false;
                }
                prev = val;

            } else {
                ind++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        CheckIfNumberInAscending c = new CheckIfNumberInAscending();
        System.out.println(c.areNumbersAscending(s));
    }

}
