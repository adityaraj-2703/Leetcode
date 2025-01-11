package design.flyweightDesignPattern.after;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        List<FlyingBullet> bullets = new ArrayList<>();
        Map<Integer,Bullet> type_bullet_map = new HashMap<>();
        for(int i=0;i<72000;i++){

            FlyingBullet flyingbullet = new FlyingBullet();
            flyingbullet.currSpeed = 1.2;
            flyingbullet.direction = 12;
            flyingbullet.longitude = 1;
            flyingbullet.latitiude = 2;
            flyingbullet.shotByUserID = 12344;
            int calibre = 566;
            if(type_bullet_map.get(calibre)==null){
                Bullet b = new Bullet();
                b.calibre = calibre;
                b.type = "aaa";
                b.damage = 1233;
                b.image = new byte[2000];
                b.weight = 5757;
                type_bullet_map.put(calibre, b);

            }
            flyingbullet.bullet = type_bullet_map.get(calibre);

            
            bullets.add(flyingbullet);

        }
        System.out.println("debug line");;
    }
}
//ideally floating points should not be a map key