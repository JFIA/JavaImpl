package com.rafel.DesignPatterns.strategy;

public class Strategy {
    Fruit fruit;
    public Strategy(Fruit fruit){
        this.fruit=fruit;
    }

    public void howToEat(){
        fruit.product();
        fruit.eat();
        fruit.product();
    }
}
