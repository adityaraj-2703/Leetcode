package design.strategyDesignPattern;

import java.util.ArrayDeque;
import java.util.Queue;

public class FIFOPageReplacementStrategy implements PageReplacementStrategy,AddPageEventSubscriber{

    FIFOPageReplacementStrategy(OS os){
        os.register(this);
    }
    Queue<Page> pages = new ArrayDeque<>();
    @Override
    public void replace() {
        // TODO Auto-generated method stub
        System.out.println("removing from fifo");
        Page p = pages.remove();
        System.out.println("removed" + p.name);
        
    }
    @Override
    public void onAddPage(Page p) {
        // TODO Auto-generated method stub
        pages.add(p);

    }

}
