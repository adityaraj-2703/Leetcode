package design.pubsubsystemd;

import java.util.HashSet;
import java.util.Set;

public class Publisher {
    private final Set<Topic> topics;

    public Publisher() {
        this.topics = new HashSet<>();
    }

    public void registerTopic(Topic t) {
        this.topics.add(t);
    }

    public void publishTopic(Topic t, Message m) {
        if (!this.topics.contains(t)) {
            System.out.println("this publisher cant publish topics" + t.getName());
            return;
        }
        t.Publish(m);
    }

}
