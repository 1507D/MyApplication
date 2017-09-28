package muhanxi.myapplication.observer;

/**
 * Created by muhanxi on 17/9/28.
 */

public class Test {


    public static void main(String [] args) {

        Child child = new Child();

        CryListener father = new Father();
        CryListener mother = new Mother();

        child.register(father);
        child.register(mother);

        System.out.println("register ok ");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        child.cry();

    }

}
