package design.decoratorDesignPattern.addons;

import java.security.InvalidParameterException;

import design.decoratorDesignPattern.IceCream;

public class VanillaScoop implements IceCream{
    private IceCream i;
    public VanillaScoop(IceCream i){
        if(i == null){
            throw new InvalidParameterException();
        }
        this.i = i;
    }
    @Override
    public int getCost() {
        // TODO Auto-generated method stub
        return this.i.getCost() + 50;
    }

    @Override
    public String getComposition() {
        // TODO Auto-generated method stub
        return this.i.getComposition() + " Vanilla Scoop";
    }
    @Override
    public boolean hasIngrediant() {
        // TODO Auto-generated method stub
        return true;
    }

}
