package lld.pen.models;

import lld.pen.strategy.RefillingStrategy;

public class GelPen extends Pen{

    public GelPen(PenBody penBody, PenInk penInk, PenNib penNib, Double length,RefillingStrategy strategy){
        super(penBody,penInk,penNib,length,strategy);
    }

    @Override
    public void write() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void refill() {
        // TODO Auto-generated method stub
        this.getStrategy().refill(this);
    }

}
