package lesson6;

import lesson6.animals.Animals;
import lesson6.animals.Cat;
import lesson6.animals.Dog;

public class MainHW6 {

    public static void main(String[] args) {

        Animals cat1 = new Cat("Барсик");
        cat1.run(150);
        cat1.swim(1);

        Animals cat2 = new Cat("Мурзик");
        cat2.run(250);
        cat2.swim(-15);

        Animals dog1 = new Dog("Тузик");
        dog1.run(450);
        dog1.swim(9);

        Animals dog2 = new Dog("Тузик");
        dog2.run(650);
        dog2.swim(-7);
    }
}
