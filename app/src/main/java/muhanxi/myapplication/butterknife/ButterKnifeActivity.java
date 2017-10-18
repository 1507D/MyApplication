package muhanxi.myapplication.butterknife;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import muhanxi.myapplication.R;

public class ButterKnifeActivity extends Activity {


    @BindView(R.id.radioButton)
    RadioButton radioButton1;
    @BindView(R.id.checkedTextView)
    CheckedTextView checkedTextView;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife);
        ButterKnife.bind(this);





    }


    @OnClick({R.id.radioButton, R.id.checkedTextView, R.id.spinner, R.id.progressBar})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.radioButton:

                break;
            case R.id.checkedTextView:
                break;
            case R.id.spinner:
                break;
            case R.id.progressBar:
                break;
        }
    }
}
