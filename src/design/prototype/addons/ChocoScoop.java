package design.prototype.addons;

import java.security.InvalidParameterException;

import design.prototype.Icecream;
import design.prototype.Prototype;

public class ChocoScoop implements Icecream{

    private Icecream icecream;
    public ChocoScoop(Icecream icecream){
        if(icecream == null){
            throw new InvalidParameterException();
        }
        this.icecream = icecream;
    }
    @Override
    public int getCost() {
        // TODO Auto-generated method stub
        return this.icecream.getCost()+30;
    }

    @Override
    public String getComposition() {
        // TODO Auto-generated method stub
        return this.icecream.getComposition() + "ChocoScoop";
    }

    @Override
    public boolean hasIngrediant() {
        // TODO Auto-generated method stub
        return true;
    }


    @Override
    public Prototype clone() {
        // TODO
        return new ChocoScoop((Icecream)this.icecream.clone());
        
    }
}
