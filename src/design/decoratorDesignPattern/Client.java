package design.decoratorDesignPattern;

import design.decoratorDesignPattern.addons.ChocoScoop;
import design.decoratorDesignPattern.addons.VanillaScoop;
import design.decoratorDesignPattern.cones.ChocolateCone;

public class Client {
    public static void main(String[] args) {
        
        IceCream chocoVanillaChocolateCone = new ChocoScoop(new VanillaScoop(new ChocolateCone()));
        System.out.println(chocoVanillaChocolateCone.getComposition());
    }
}
