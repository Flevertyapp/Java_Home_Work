package lesson6.animals;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Cat extends Animals {
    int maxRun;
    int maxSwim;
    boolean canSwim;

    public Cat (String name) {
        super(name);
        maxRun = 200;
        maxSwim = 0;
        canSwim = false;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxSwim() {
        return maxSwim;
    }

    public boolean isCanSwim() {
        System.out.println("коты не умеют плавать!");
        return canSwim;
    }

}






