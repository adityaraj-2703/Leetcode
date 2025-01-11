package design.decoratorDesignPattern.addons;

import java.security.InvalidParameterException;

import design.decoratorDesignPattern.IceCream;

public class ChocoScoop implements IceCream{

    private IceCream i;
    public ChocoScoop(IceCream i){
        if(i==null){
            throw new InvalidParameterException();
        }
        this.i = i;
    }
    @Override
    public int getCost() {
        // TODO Auto-generated method stub
        return this.i.getCost() + 30;
    }

    @Override
    public String getComposition() {
        // TODO Auto-generated method stub
        return this.i.getComposition() + " Choco Scoop";
    }
    @Override
    public boolean hasIngrediant() {
        // TODO Auto-generated method stub
        return true;
    }

}
