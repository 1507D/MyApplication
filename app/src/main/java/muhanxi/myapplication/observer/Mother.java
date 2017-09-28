package muhanxi.myapplication.observer;

/**
 * Created by muhanxi on 17/9/28.
 */

public class Mother  implements CryListener {
    @Override
    public void cry() {
        System.out.println(" Mother = CryListener" );
    }
}
