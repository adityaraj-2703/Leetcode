package math;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {
    List<Integer> prefix;
    int product = 1;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
    }

    public void add(int num) {
        if (prefix.size() == 0) {
            prefix.add(num);
            product *= num;
            return;
        }
        if (num == 0) {
            product = 1;
            prefix.add(0);
        } else {
            product *= num;
            prefix.add(product);
        }
        for (int i = 0; i < prefix.size(); i++) {
            System.out.print(prefix.get(i) + ", ");
        }
        System.out.println();
    }

    public int getProduct(int k) {
        if (prefix.get(prefix.size() - k - 1) == 0) {
            return prefix.get(prefix.size() - 1);
        }
        return prefix.get(prefix.size() - 1) / prefix.get(prefix.size() - k - 1);
    }

    public static void main(String[] args) {
        ProductOfNumbers p = new ProductOfNumbers();
        p.add(3);
        p.add(0);
        p.add(2);
        p.add(5);
        p.add(4);
        System.out.println(p.getProduct(2));
        System.out.println(p.getProduct(3));
        System.out.println(p.getProduct(4));
        p.add(8);
        System.out.println(p.getProduct(2));
    }
}
