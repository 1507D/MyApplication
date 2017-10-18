package muhanxi.myapplication.proxy;

import java.lang.reflect.Proxy;

import static java.lang.reflect.Proxy.newProxyInstance;

/**
 * Created by muhanxi on 17/10/12.
 */

public class Test {


    public static void main(String [] args) {

        LianJia lianJia = new FangDong();

        LianJia proxy = (LianJia) Proxy.newProxyInstance(LianJia.class.getClassLoader(),new Class[]{LianJia.class},new IVocationHandler(lianJia));

        proxy.zufang(1);

        proxy.shouqian();
    }

}
