package muhanxi.myapplication.spannable;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import muhanxi.myapplication.R;

public class SpannableActivity extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spannable);

        textView = (TextView) findViewById(R.id.textview);


        SpannableString spannableString = new SpannableString("1507D牛伟最帅");

//        spannableString.setSpan(new BackgroundColorSpan(Color.GREEN),0,5, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

//        spannableString.setSpan(new ForegroundColorSpan(Color.GREEN),5,6,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

//        spannableString.setSpan(new UnderlineSpan(),0,6,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);



        Drawable drawable =  getResources().getDrawable(R.mipmap.ic_launcher);

        drawable.setBounds(0,0,80,80);

//        https://github.com/ReactiveX/RxJava
        //图文混排

        // 1507D[爱心]班级学习特别好[微笑]

//        spannableString.setSpan(new ImageSpan(drawable),5,6,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

//        spannableString.setSpan(new StyleSpan(Typeface.BOLD_ITALIC),5,7,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

//        spannableString.setSpan(new SubscriptSpan(),5,7,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

//       spannableString.setSpan(new URLSpan("http://www.baidu.com"),5,7,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

//       spannableString.setSpan(new ForegroundColorSpan(Color.GREEN),4,5,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);


        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {


                System.out.println("widget = " + widget);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);

                ds.setColor(Color.RED);
                ds.setUnderlineText(true);

            }
        },4,6,Spannable.SPAN_INCLUSIVE_EXCLUSIVE);


        textView.setText(spannableString);
        textView.setMovementMethod(new LinkMovementMethod());


        EditText editText = (EditText) findViewById(R.id.edittext);

        SpannableString spannableString1 = new SpannableString("1507D牛伟最帅");


        spannableString1.setSpan(new ForegroundColorSpan(Color.GREEN),0,4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);


        editText.setText(spannableString1);

    }
}
