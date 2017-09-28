package muhanxi.myapplication.observer;

/**
 * Created by muhanxi on 17/9/28.
 */

public class Father implements CryListener {
    @Override
    public void cry() {
        System.out.println(" Father = CryListener" );
    }
}
