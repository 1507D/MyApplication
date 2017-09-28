package muhanxi.myapplication.callback;

/**
 * Created by muhanxi on 17/9/28.
 */

public class Test2 {


    public void add(int a,int b){

        //模拟耗时操作
        // 在子线程
        int result =   a+ b ;


        if(listener != null){
            listener.add(result);
        }

    }


    public AddListener listener ;

    public void setListener(AddListener listener){
        this.listener  = listener ;
    }


    interface  AddListener {
        public void add(int result);
    }


}
