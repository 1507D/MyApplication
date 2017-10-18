package muhanxi.myapplication.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by muhanxi on 17/10/12.
 */

public class IVocationHandler implements InvocationHandler {

    private Object object ;
    public IVocationHandler(Object o){
        this.object = o ;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        System.out.println("IVocationHandler = ---");

        Object result =  method.invoke(object,args);

        System.out.println("IVocationHandler = =====");


        return result ;
    }
}
