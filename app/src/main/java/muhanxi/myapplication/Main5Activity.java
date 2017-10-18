package muhanxi.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import muhanxi.myapplication.event.Event1507;

public class Main5Activity extends Activity {

    @BindView(R.id.btn_presenter11)
    Button btnPresenter11;
    @BindView(R.id.btn_next)
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ButterKnife.bind(this);


//        EventBus.getDefault().register(this);


        findViewById(R.id.btn_presenter11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//start();


//                EventBus.getDefault().post(new Event1507("1","2"));


                EventBus.getDefault().postSticky(new Event1507("1", "2"));

            }
        });


        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                start();


            }
        });

    }

    public void start() {
        startActivity(new Intent(this, Main6Activity.class));
    }
//
//    @Subscribe
//    public void onEvent(Event1507 event){
//        System.out.println("event = Main5Activity "  + event.toString());
//
//    }


    public void re() {


    }

    @OnClick({R.id.btn_presenter11, R.id.btn_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_presenter11:
                break;
            case R.id.btn_next:
                break;
        }
    }
}
