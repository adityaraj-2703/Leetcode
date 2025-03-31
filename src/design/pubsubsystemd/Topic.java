package design.pubsubsystemd;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Topic {
    private final String name;
    private final Set<Subscriber> subscribers = new CopyOnWriteArraySet<>();

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSubscriber(Subscriber s) {
        this.subscribers.add(s);
    }

    public void removeSubscriber(Subscriber s) {
        this.subscribers.remove(s);
    }

    public void Publish(Message m) {
        for (Subscriber s : subscribers) {
            s.onMesage(m);
        }
    }

}
