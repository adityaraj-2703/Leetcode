package design.pubsubsystemd;

public interface Subscriber {
    void onMesage(Message message);
}
