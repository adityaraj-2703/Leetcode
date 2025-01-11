package design.strategyDesignPattern;

public class PageReplacementStrategyFactory {
    public static PageReplacementStrategy geStrategyAlgoType(PgaeReplacementAlgoType p,OS os){
        switch(p){
            case LFU : return new LFUPageReplacementStrategy();
            case LRU : return new LRUPageReplacementStrategy();
            case FIFO : return new FIFOPageReplacementStrategy(os);
            default : return null;
        }
    }

}
