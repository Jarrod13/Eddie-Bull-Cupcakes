package com.liamgoodwin.eddiebullcupcakes;

public class PeanutButterCup extends CupcakeCalculatorFragment {
    public static double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static double price = 2.75;
}
