package muhanxi.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import muhanxi.myapplication.event.Event1507;

public class Main6Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
//
//        if(EventBus.getDefault().isRegistered(this)){
//
//        }
        EventBus.getDefault().register(this);


        findViewById(R.id.btn_presenter11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //发布事件


//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        EventBus.getDefault().post(new Event1507("1","100"));
//                    }
//                }).start();
//                EventBus.getDefault().post(new Event1507("1","100"));





            }
        });


    }


    @Subscribe(threadMode = ThreadMode.POSTING , sticky = true)
    public void onMessageEvent(Event1507 event){

        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("event = Main6Activity "  + event.toString());
    }

}
