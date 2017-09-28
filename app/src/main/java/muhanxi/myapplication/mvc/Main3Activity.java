package muhanxi.myapplication.mvc;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import muhanxi.myapplication.R;

public class Main3Activity extends Activity {

    private EditText editTextName;
    private EditText editTextPass;
    private Main3ActivityModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        editTextName = (EditText) findViewById(R.id.username);
        editTextPass = (EditText) findViewById(R.id.password);

        model = new Main3ActivityModel();



        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


String username = editTextName.getText().toString().trim() ;
                if(TextUtils.isEmpty(username)){
                    Toast.makeText(Main3Activity.this, "user name is null", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 手机号码 是否合法
                String password = editTextPass.getText().toString().trim() ;

                if(TextUtils.isEmpty(editTextPass.getText().toString().trim())){
                    Toast.makeText(Main3Activity.this, "password name is null", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 密码是否合法

                model.login(username,password);




            }
        });

        model.setListener(new Main3ActivityModel.LoginListener() {
            @Override
            public void loginSuccess(final String result) {


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Main3Activity.this, "login success" + result, Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });




    }
}
