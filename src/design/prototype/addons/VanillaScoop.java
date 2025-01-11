package design.prototype.addons;

import java.security.InvalidParameterException;

import design.prototype.Icecream;
import design.prototype.Prototype;
import design.prototype.cones.OrangeCone;

public class VanillaScoop implements Icecream{

    private Icecream icecream;
    public VanillaScoop(Icecream icecream){
        if(icecream == null){
            throw new InvalidParameterException();
        }
        this.icecream = icecream;
    }
    @Override
    public int getCost() {
        // TODO Auto-generated method stub
        return this.icecream.getCost()+25;
    }

    @Override
    public String getComposition() {
        // TODO Auto-generated method stub
        return this.icecream.getComposition() + "VanillaScoop";
    }

    @Override
    public boolean hasIngrediant() {
        // TODO Auto-generated method stub
        return true;
    }


    @Override
    public Prototype clone() {
        // TODO
        return new VanillaScoop((Icecream)this.icecream.clone());
    }
}
