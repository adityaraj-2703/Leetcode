package design.elevatorsimplified;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private final int id;
    private final int capacity;
    private int currFloor;
    private Direction currDirection;
    private final List<Request> requests;

    Elevator(int id, int capacity) {
        this.capacity = capacity;
        this.id = id;
        this.currFloor = 1;
        this.currDirection = Direction.UP;
        this.requests = new ArrayList<>();
    }

    public synchronized void addRequest(Request req) {
        if (requests.size() < capacity) {
            requests.add(req);
            System.out.println("Elevator" + id + "added request: " + req.getDestFloor());
            notifyAll();
        }
    }

    public synchronized Request getNextRequest() {
        while (requests.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return requests.get(0);
    }

    public synchronized void processRequest() {
        while (true) {
            while (!requests.isEmpty()) {
                Request r = getNextRequest();
                processRequest(r);
            }
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void processRequest(Request r) {
        int startFloor = currFloor;
        int endFloor = r.getDestFloor();
        if (startFloor < endFloor) {
            currDirection = Direction.UP;
            for (int i = startFloor; i <= endFloor; i++) {
                currFloor = i;
                System.out.println("Elevator " + id + " reached floor " + currFloor + "direction: " + currDirection);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (startFloor > r.getDestFloor()) {
            this.currDirection = Direction.DOWN;
            for (int i = startFloor; i <= endFloor; i--) {
                currFloor = i;
                System.out.println("Elevator " + id + " reached floor " + currFloor + "direction: " + currDirection);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        processRequest();
    }

    public int getCurrentFloor() {
        return this.currFloor;
    }

}
