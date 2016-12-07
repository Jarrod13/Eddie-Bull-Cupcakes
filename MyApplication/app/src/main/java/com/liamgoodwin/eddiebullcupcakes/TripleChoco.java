package com.liamgoodwin.eddiebullcupcakes;

public class TripleChoco extends CupcakeCalculatorFragment {
    public static double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @param price is the price of this cupcake
     */
    public static double price = 2.15;
}
