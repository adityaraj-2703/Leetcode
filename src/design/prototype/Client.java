package design.prototype;

import design.prototype.addons.ChocoScoop;
import design.prototype.addons.VanillaScoop;
import design.prototype.cones.ChocolateCone;
import design.prototype.cones.OrangeCone;
import design.prototype.cones.VanillaCone;

public class Client {
    public static void main(String[] args) {
        IcecreamRegistry icecreamRegistry= new IcecreamRegistry();
        
        Icecream chocoVanillaOrangeChoco =
        new ChocoScoop(
            new VanillaScoop(
                new OrangeCone(
                        new ChocolateCone()
                )
            )
        );
        icecreamRegistry.put(IcecreamMenu.chocoVanillaOrangeChoco, chocoVanillaOrangeChoco);

        Icecream chocoVanillaChocoOrangeVanilla = new VanillaScoop(new ChocolateCone(new OrangeCone(new VanillaCone())));
        icecreamRegistry.put(IcecreamMenu.chocoVanillaChocoOrangeVanilla, chocoVanillaChocoOrangeVanilla);
        System.out.println(chocoVanillaChocoOrangeVanilla.getComposition());

        Icecream clone = icecreamRegistry.get(IcecreamMenu.chocoVanillaOrangeChoco);
        Icecream order = new ChocoScoop(clone);
        System.out.println(order);

    }

}
