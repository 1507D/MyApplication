package muhanxi.myapplication.mvp;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import muhanxi.myapplication.mvc.Main3Activity;

/**
 * Created by muhanxi on 17/9/28.
 */

public class Main4ActivityPresenter {



    private LoginView loginView ;
    private Main4ActivityModel main4ActivityModel ;
    public Main4ActivityPresenter(LoginView loginView){
        this.loginView = loginView;
        this.main4ActivityModel = new Main4ActivityModel();
    }


    public void login(String username,String password){


        if(TextUtils.isEmpty(username)){
            loginView.usernameNull();

            return;
        }

        // 手机号码 是否合法

        if(TextUtils.isEmpty(password)){
            loginView.passwordNull();
            return;
        }


        main4ActivityModel.login(username, password, new Main4ActivityModel.ModelListener() {
            @Override
            public void loginSuccess(String result) {

                loginView.loginSuccess(result);

            }
        });

    }



    public void detach(){
        loginView = null;
    }

}
