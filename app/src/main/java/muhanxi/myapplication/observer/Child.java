package muhanxi.myapplication.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muhanxi on 17/9/28.
 *
 */

public class Child {

    public List<CryListener> list = new ArrayList<CryListener>();


    /**
     * 注册监听
     * @param listener
     */
    public void register(CryListener listener){
        list.add(listener);
    }



    //小孩 哭的方法
    public void cry(){

        System.out.println(" child cry ");

        for(CryListener cry : list){

            cry.cry();
        }


    }


}
