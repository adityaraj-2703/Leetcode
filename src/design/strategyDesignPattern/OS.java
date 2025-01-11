package design.strategyDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class OS {
    List<Page> pages = new ArrayList<>();
    PageReplacementStrategy strategy;
    List<AddPageEventSubscriber> addPageEventSubscribers = new ArrayList<>();

    OS(PgaeReplacementAlgoType p){
        this.strategy = PageReplacementStrategyFactory.geStrategyAlgoType(p, this);
    }

    void register(AddPageEventSubscriber addPageEventSubscriber){
        this.addPageEventSubscribers.add(addPageEventSubscriber);
    }
    void deRegister(AddPageEventSubscriber addPageEventSubscriber){
        this.addPageEventSubscribers.remove(addPageEventSubscriber);
    }

    void addPage(Page p){
        // if(this.pages.size() > 3){
        //     strategy.
        // }
        this.pages.add(p);
        for(AddPageEventSubscriber a : addPageEventSubscribers){
            a.onAddPage(p);
        }
    }
    void doCleanUp(){
        strategy.replace();
    }

}
