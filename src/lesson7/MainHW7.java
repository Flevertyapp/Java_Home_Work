package lesson7;

public class MainHW7 {
    public static void main(String[] args) {

        Plate plate = new Plate();
        plate.setFood(50);
        plate.printPlateInfo();

        Cat [] catsArray = new Cat [5];
        catsArray[0] = new Cat("Барсик");
        catsArray[1] = new Cat("Василий");
        catsArray[2] = new Cat("Мурка");
        catsArray[3] = new Cat("Ластик");
        catsArray[4] = new Cat("Шерхан");

        for (int i = 0; i < catsArray.length ; i++) {
            catsArray[i].eat(plate);
            plate.plateInfo();
        }

    }
}
