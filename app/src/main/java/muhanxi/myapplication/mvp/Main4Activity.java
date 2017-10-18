package muhanxi.myapplication.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import muhanxi.myapplication.R;
import muhanxi.myapplication.mvc.Main3Activity;
import muhanxi.myapplication.mvc.Main3ActivityModel;

public class Main4Activity extends Activity implements LoginView {

    private EditText editTextName;
    private EditText editTextPass;
    private Main4ActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        editTextName = (EditText) findViewById(R.id.username);
        editTextPass = (EditText) findViewById(R.id.password);


        presenter = new Main4ActivityPresenter(this);


        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextName.getText().toString().trim() ;
                String password = editTextPass.getText().toString().trim() ;
                presenter.login(username,password);

            }
        });

        // m v p
//        v activity
//        p present
//         m module


    }

    @Override
    public void usernameNull() {

        Toast.makeText(this, "usernameNull", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passwordNull() {
        Toast.makeText(this, "passwordNull", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loginSuccess(final String result) {


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Main4Activity.this, "loginSuccess" + result, Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detach();
    }
}
