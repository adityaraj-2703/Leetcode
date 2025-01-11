package lld.pen;

import lld.pen.models.GelPen;
import lld.pen.models.PenBody;
import lld.pen.models.PenInk;
import lld.pen.models.PenNib;
import lld.pen.strategy.ReplaceRefillStrategy;

public class Client {
    public static void main(String[] args) {
        GelPen p = new GelPen(new PenBody(), new PenInk(), new PenNib(), 8.5, new ReplaceRefillStrategy());
        p.refill();
    }
}
