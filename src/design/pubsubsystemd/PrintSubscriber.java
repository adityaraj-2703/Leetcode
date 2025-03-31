package design.pubsubsystemd;

public class PrintSubscriber implements Subscriber {
    private final String name;

    public PrintSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onMesage(Message message) {
        // TODO Auto-generated method stub
        System.out.println("this person:" + name + "received this message: " + message.getContent());
    }

}
