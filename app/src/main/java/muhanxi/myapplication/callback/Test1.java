package muhanxi.myapplication.callback;

/**
 * Created by muhanxi on 17/9/28.
 */

public class Test1 {

    public static void main(String [] args){

        Test2 test2 = new Test2();
        test2.setListener(new Test2.AddListener() {
            @Override
            public void add(int result) {
                System.out.println("result = " + result);
            }
        });
        test2.add(1,2);

    }

}
