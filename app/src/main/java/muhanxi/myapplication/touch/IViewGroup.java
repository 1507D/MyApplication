package muhanxi.myapplication.touch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by muhanxi on 17/10/17.
 */

public class IViewGroup extends LinearLayout {
    public IViewGroup(Context context) {
        super(context);
    }

    public IViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public IViewGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public IViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        System.out.println("ev =  IViewGroup dispatchTouchEvent");

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        System.out.println("ev =  IViewGroup onInterceptTouchEvent");

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("ev =  IViewGroup onTouchEvent");

//        return false;
        return super.onTouchEvent(event);
    }


}
