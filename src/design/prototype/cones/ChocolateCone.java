package design.prototype.cones;

import java.security.InvalidParameterException;

import design.prototype.Icecream;
import design.prototype.Prototype;

public class ChocolateCone implements Icecream{
    private Icecream icecream;
    public ChocolateCone(){}

    public ChocolateCone(Icecream icecream){
        if(icecream == null){
            throw new InvalidParameterException();
        }
        if(icecream.hasIngrediant()){
            throw new InvalidParameterException();
        }
        this.icecream = icecream;
    }

    @Override
    public int getCost() {
        // TODO Auto-generated method stub
        int cost = ConeCosts.CHOCO_COST;
        if(this.icecream!=null){
            cost += icecream.getCost();
        }
        return cost;
    }

    @Override
    public String getComposition() {
        // TODO Auto-generated method stub
        String desc = "Chocolate Cone";
        if(this.icecream!=null){
            desc = this.icecream.getComposition() + desc;
        }
        return desc;
    }

    @Override
    public boolean hasIngrediant() {
        // TODO Auto-generated method stub
        return false;
    }
    


    @Override
    public Prototype clone() {
        // TODO
        if(this.icecream==null){
            return new ChocolateCone();
        }
        ChocolateCone copy = new ChocolateCone((Icecream)this.icecream.clone());
        return copy;
    }
}
