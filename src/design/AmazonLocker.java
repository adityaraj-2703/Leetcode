package design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;

public class AmazonLocker {
    Map<Size, Queue<Locker>> availableLockers = new HashMap<>();
    Map<String, Locker> packageLoc = new HashMap<>();

    public AmazonLocker(Map<Size, Integer> sizes) {
        for (Map.Entry<Size, Integer> m : sizes.entrySet()) {
            Queue<Locker> lockerQ = new LinkedList<>();
            for (int j = 0; j < m.getValue(); j++) {
                lockerQ.add(new Locker(m.getKey()));
            }
            availableLockers.put(m.getKey(), lockerQ);
        }
    }

    public Locker assignPackage(Package p) {
        for (Size s : Size.values()) {
            if (s.getNum() < p.getSize().getNum()) {
                continue;
            }
            Locker l = assignLocker(p, s);
            return l;
        }
        return null;
    }

    public Locker assignLocker(Package p, Size s) {
        if (availableLockers.get(s).size() == 0) {
            return null;
        }
        Locker lockerToAssign = availableLockers.get(s).poll();
        lockerToAssign.assignPackage(p);
        packageLoc.put(p.getPackageId(), lockerToAssign);
        return lockerToAssign;
    }

    public Package getPackage(Package p) {
        if (!packageLoc.containsKey(p.getPackageId())) {
            return null;
        }
        Locker l = packageLoc.get(p.getPackageId());
        Package p1 = l.emptyLocker();
        availableLockers.get(l.getSize()).add(l);
        return p1;
    }

    public static void main(String[] args) {
        Map<Size, Integer> m = new HashMap<>();
        m.put(Size.SMALL, 2);
        m.put(Size.LARGE, 2);
        m.put(Size.MEDIUM, 2);

        AmazonLocker a = new AmazonLocker(m);

        Package p = new Package(Size.SMALL);
        Locker l1 = a.assignPackage(p);
        System.out.println(l1.getSize());
        Package p11 = new Package(Size.SMALL);
        Locker l111 = a.assignPackage(p11);
        System.out.println(l111.getSize());
        a.getPackage(p11);
        Package p22 = new Package(Size.SMALL);
        try {
            Locker l22 = a.assignPackage(p22);
            System.out.println(l22.getSize());
        } catch (Exception e) {
            System.out.println("not able to assign locker");
        }

    }

}

class Locker {
    private final Size lockerSize;
    private final String lockerId;

    public Locker(Size s) {
        this.lockerSize = s;
        lockerId = UUID.randomUUID().toString();
    }

    private Package pack;

    public Size getSize() {
        return lockerSize;
    }

    private String getId() {
        return lockerId;

    }

    public void assignPackage(Package p) {
        pack = p;
    }

    public Package emptyLocker() {
        Package p = this.pack;
        this.pack = null;
        return p;

    }
}

class Package {
    private final Size packageSize;
    private final String packageId;

    Package(Size s) {
        this.packageSize = s;
        packageId = UUID.randomUUID().toString();
    }

    public Size getSize() {
        return this.packageSize;
    }

    public String getPackageId() {
        return this.packageId;
    }
}

enum Size {
    SMALL(0),
    MEDIUM(1),
    LARGE(2);

    private int size;

    Size(int size) {
        this.size = size;
    }

    public int getNum() {
        return this.size;
    }

}
