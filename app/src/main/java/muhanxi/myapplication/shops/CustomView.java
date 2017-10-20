package muhanxi.myapplication.shops;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import muhanxi.myapplication.R;

import static android.R.attr.start;

/**
 * Created by muhanxi on 17/10/20.
 */

public class CustomView extends LinearLayout {

    private EditText content;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


        View view =  LayoutInflater.from(context).inflate(R.layout.customview,null);
        addView(view);


        Button revserse = (Button) view.findViewById(R.id.revserse);
        Button add = (Button) view.findViewById(R.id.add);
        content = (EditText) view.findViewById(R.id.content);



        revserse.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

               String  result =   content.getText().toString().trim() ;

               int integerResult =  Integer.valueOf(result);

                if(integerResult > 1){
                    integerResult = integerResult - 1 ;

                    content.setText(integerResult+"");
                    if(listener != null){
                        listener.onChange(integerResult);
                    }
                }


            }
        });

        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String  result =   content.getText().toString().trim() ;
                int integerResult =  Integer.valueOf(result);
                integerResult = integerResult + 1 ;
                content.setText(integerResult+"");
                if(listener != null){
                    listener.onChange(integerResult);
                }

            }
        });




        content.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

//                System.out.println("beforeTextChanged  = s " + s + " start  " + start + " count " + count );

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                System.out.println("onTextChanged  = s " + s + " start  " + start + " before " + before );

            }

            @Override
            public void afterTextChanged(Editable s) {
                System.out.println("afterTextChanged  = s " + s.toString() );
//                content.setText( s.toString());
                if(listener != null){
                    listener.onChange(Integer.valueOf(s.toString()));
                }
            }
        });






    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    public ChangeListener listener ;

    public void setListener(ChangeListener listener){
        this.listener = listener;
    }


    interface ChangeListener{

        public void onChange(int count);

    }


}
