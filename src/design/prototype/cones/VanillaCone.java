package design.prototype.cones;

import java.security.InvalidParameterException;

import design.prototype.Icecream;
import design.prototype.Prototype;

public class VanillaCone implements Icecream{
    private Icecream icecream;
    public VanillaCone(){}

    public VanillaCone(Icecream icecream){
        if(this.icecream == null){
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
        int cost = ConeCosts.VANILLA_COST;
        if(this.icecream!=null){
            cost += icecream.getCost();
        }
        return cost;
    }

    @Override
    public String getComposition() {
        // TODO Auto-generated method stub
        String desc = "Vanilla Cone";
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
            return new VanillaCone();
        }
        VanillaCone copy = new VanillaCone((Icecream)this.icecream.clone());
        return copy;
    }
}
