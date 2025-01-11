package design.prototype;

import java.util.HashMap;
import java.util.Map;

public class IcecreamRegistry {
    Map<String,Icecream> stringIcecreamMap = new HashMap<>();

    Icecream get(String key){
        return (Icecream)stringIcecreamMap.get(key).clone();
    }
    void put(String key,Icecream icecream){
        stringIcecreamMap.put(key,icecream);
    }
}
