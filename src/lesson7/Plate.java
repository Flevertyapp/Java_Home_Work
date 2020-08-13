package lesson7;

public class Plate {


    public int food;

    public void setFood(int food) {
        this.food = food;
    }

    public Plate() {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public int plateInfo(){
        return food;
    }
    public void printPlateInfo(){
        System.out.println("Количество еды в миске- " + food);
    }

    public void decreaseFood(int appetite) {
        if (food <= 0) {
            System.out.println("В миске слишком мало еды! Наполните миску");
        } else {
            food = food - appetite;
        }
    }
}
