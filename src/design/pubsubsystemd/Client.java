package design.pubsubsystemd;

public class Client {
    public static void main(String[] args) {
        Topic t1 = new Topic("topic 1");
        Topic t2 = new Topic("topic 2");

        Publisher p1 = new Publisher();
        Publisher p2 = new Publisher();

        Subscriber s1 = new PrintSubscriber("Subscriber 1");
        Subscriber s2 = new PrintSubscriber("Subscriber 2");
        Subscriber s3 = new PrintSubscriber("Subscriber 3");

        p1.registerTopic(t1);
        p2.registerTopic(t2);

        t1.addSubscriber(s1);
        t1.addSubscriber(s2);
        t2.addSubscriber(s1);
        t2.addSubscriber(s2);

        p1.publishTopic(t1, new Message("message1 for t1"));
        p1.publishTopic(t1, new Message("message2 for t1"));
        p2.publishTopic(t2, new Message("message1 for t2"));

        t1.removeSubscriber(s2);

        p1.publishTopic(t1, new Message("message3 for t1"));
        p2.publishTopic(t2, new Message("message2 for t2"));

    }

}
