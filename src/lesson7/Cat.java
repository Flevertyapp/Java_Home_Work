package lesson7;

import java.util.Random;

public class Cat {

    private String name;
    private int satiety = 0;
    private int appetite = (int) (Math.random()* 30);

    public Cat(String name, int satiety, int appetite) {
        this.name = name;
        this.satiety = satiety;
        this.appetite = appetite;
    }

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate) {
        if (appetite <= plate.plateInfo()) {
            System.out.println(name + " поел ");
            plate.decreaseFood(appetite);
            satiety =+ appetite;
            System.out.println(satietyCat());
            catInfo();

        } else {
            System.out.println( name + " нужно еды " + appetite + " Пополните миску!");
            System.out.println(satietyCat());
        }
    }

    public void catInfo(){
        System.out.println(name + " сытость: " + satiety + "  аппетит: " + appetite);
    }

    public boolean satietyCat(){
        if (appetite == satiety){
            return true;
        } else {
            return false;
        }
    }
}
