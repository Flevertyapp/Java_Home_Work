package lesson6.animals;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Animals {

    private String name;
    private int distance;
    private int maxRun;
    private int maxSwim;
    private boolean canSwim;
    int count;

    public Animals (String name) {
        super();
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    //Метод для бега
    public int getMaxRun() { //узнаем максимум, который животное может пробежать
        return maxRun;
    }

    public void run(int distance) {  //проверяем условия + защита от дурака
        if (distance < 0) {
            System.out.println("Введено отрицательное число!");
        } else if (getMaxRun() < distance) {
            System.out.println(name + " не может пробежать такую большую дистанцию");
        } else {
            System.out.println(name + " пробежал " + distance + " метров");}
    }

    //Метод для плавания
    public boolean isCanSwim() { //Узнаем умеет ли животное плавать
        return canSwim;
    }

    public int getMaxSwim() { //узнаем максимум, который животное может проплыть
        return maxSwim;
    }

    public void swim(int distance) { //проверяем условия + защита от дурака
        if (!isCanSwim()) { //заглушка, если животное не умеет плавать, не заходим в цикл и печатаем сообщение из класса кота
            //System.out.println("Коты не умеют плавать"); //реализация для двух классов, реализация с заглушкой поидее лучше
        } else {
            if (distance < 0) {
                System.out.println("Введено отрицательное число!");
            } else if (distance > getMaxSwim()) {
                System.out.println(name + " не может проплыть такую большую дистанцию");
            } else {
                System.out.println(name + " проплыл " + distance + " метров");
            }
        }
    }


}
