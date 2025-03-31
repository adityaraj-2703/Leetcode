package backtracking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PunishmentNumber {
    public int punishmentNumber(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            int sum = i * i;
            List<Integer> li = listInteger(sum);
            if (punishmentNumberUtil(i, li, 0, 0)) {
                total += sum;
            }
        }
        return total;
    }

    public List<Integer> listInteger(int sum) {
        List<Integer> li = new ArrayList<>();
        while (sum > 0) {
            li.add(sum % 10);
            sum = sum / 10;
        }
        Collections.reverse(li);
        return li;
    }

    public boolean punishmentNumberUtil(int sum, List<Integer> li, int i, int temp) {
        if (i == li.size()) {
            return sum == temp;
        }
        for (int j = 0; j < i; j++) {

        }
        temp = temp * 10 + li.get(i);
        for (int j = i + 1; j < li.size(); j++) {
            return punishmentNumberUtil(sum, li, j, temp);
        }
        return false;

    }

    public static void main(String[] args) {
        PunishmentNumber p = new PunishmentNumber();
        System.out.println(p.punishmentNumber(10));
    }

}
