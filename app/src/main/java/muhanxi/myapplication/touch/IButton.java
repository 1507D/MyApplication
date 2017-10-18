package muhanxi.myapplication.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by muhanxi on 17/10/17.
 */

public class IButton extends Button {
    public IButton(Context context) {
        super(context);
    }

    public IButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public IButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        System.out.println("ev =  IButton dispatchTouchEvent");

        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("ev =  IButton onTouchEvent");

//        return false;
        return super.onTouchEvent(event);
    }
}
