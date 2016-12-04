package com.liamgoodwin.eddiebullcupcakes;

public class PumpkinSpice extends CupcakeCalculatorFragment {
    public static double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static double price = 2.25;
}
