package design.flyweightDesignPattern.before;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Bullet> bullets = new ArrayList<>();
        for(int i=0;i<72000;i++){
            Bullet bullet = new Bullet();
            bullet.currSpeed = 1.2;
            bullet.calibre = 5.6;
            bullet.damage = 123;
            bullet.image = new byte[2000];
            bullets.add(bullet);

        }
        System.out.println("debug line");
    }
}
