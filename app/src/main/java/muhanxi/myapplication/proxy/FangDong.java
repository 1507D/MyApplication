package muhanxi.myapplication.proxy;

/**
 * Created by muhanxi on 17/10/12.
 */

public class FangDong implements LianJia {


    @Override
    public void zufang(int person) {

        System.out.println("FangDong person = " + person);
    }


    @Override
    public void shouqian() {
        System.out.println("FangDong person shouqian = ");

    }
}
