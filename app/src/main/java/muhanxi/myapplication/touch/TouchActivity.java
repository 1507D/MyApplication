package muhanxi.myapplication.touch;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;

import muhanxi.myapplication.R;

public class TouchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);






    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        System.out.println("ev =  TouchActivity dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("ev =  TouchActivity onTouchEvent");

//        return false;
        return super.onTouchEvent(event);
    }
}
