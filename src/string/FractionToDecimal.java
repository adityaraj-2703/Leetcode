package string;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        Long n = Math.abs((long) numerator);
        Long d = Math.abs((long) denominator);
        StringBuilder sb = new StringBuilder();
        sb.append(n / d);

        if (n % d == 0) {

            return sb.toString();
        }
        sb.append(".");
        Long remainder = n % d;
        Map<Long, Integer> hm = new HashMap<>();
        while (remainder != 0) {
            if (hm.containsKey(remainder)) {
                sb.insert(hm.get(remainder), "(");
                sb.append(")");
                return sb.toString();
            }
            hm.put(remainder, sb.length());
            remainder = remainder * 10;
            sb.append(remainder / d);
            remainder = remainder % d;
        }
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sb.insert(0, "-");
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        FractionToDecimal f = new FractionToDecimal();
        System.out.println(f.fractionToDecimal(1, -1));
    }

}
