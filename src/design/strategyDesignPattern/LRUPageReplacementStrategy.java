package design.strategyDesignPattern;

public class LRUPageReplacementStrategy implements PageReplacementStrategy,AddPageEventSubscriber{

    @Override
    public void replace() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onAddPage(Page p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onAddPage'");
    }

}
