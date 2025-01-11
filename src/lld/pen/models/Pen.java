package lld.pen.models;

import lld.pen.strategy.RefillingStrategy;
import lld.pen.strategy.ReplaceRefillStrategy;

public abstract class Pen {
    private PenBody penBody;
    private PenInk penInk;
    private PenNib penNib;
    private Double length;
    private RefillingStrategy strategy;

    public RefillingStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(RefillingStrategy strategy) {
        this.strategy = strategy;
    }

    public Pen(PenBody penBody, PenInk penInk, PenNib penNib, Double length,RefillingStrategy strategy){
        this.penBody = penBody;
        this.penInk = penInk;
        this.penNib = penNib;
        this.length = length;
        this.strategy = new ReplaceRefillStrategy();
    }

    public PenBody getPenBody() {
        return penBody;
    }
    public PenInk getPenInk() {
        return penInk;
    }
    public PenNib getPenNib() {
        return penNib;
    }
    public Double getLength() {
        return length;
    }
    public void setPenBody(PenBody penBody) {
        this.penBody = penBody;
    }
    public void setPenInk(PenInk penInk) {
        this.penInk = penInk;
    }
    public void setPenNib(PenNib penNib) {
        this.penNib = penNib;
    }
    public void setLength(Double length) {
        this.length = length;
    }

    public abstract void write();
    public void refill(){
        this.strategy.refill(this);
    }
    

}
