package design.strategyDesignPattern;

public class Client {
    public static void main(String[] args) {
        OS os = new OS(PgaeReplacementAlgoType.FIFO);
        FIFOPageReplacementStrategy fifo = new FIFOPageReplacementStrategy(os);
        os.addPage(new Page("1"));
        os.addPage(new Page("2"));
        os.addPage(new Page("3"));
        os.doCleanUp();
    }
}
