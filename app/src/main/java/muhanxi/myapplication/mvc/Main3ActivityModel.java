package muhanxi.myapplication.mvc;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.os.Build.VERSION_CODES.O;

/**
 * Created by muhanxi on 17/9/28.
 */

public class Main3ActivityModel {




    public void login(String username,String password){

        OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
                .url("http://qhb.2dyt.com/Bwei/login?username=muhanxi&password=111&postkey=1503d")
                .build();


        Call call =  client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {



                String result = response.body().string() ;

                if(listener != null){
                    listener.loginSuccess(result);
                }

            }
        });

    }

    public LoginListener listener  ;

    public void setListener(LoginListener listener){
        this.listener = listener ;
    }


    interface LoginListener {

        public void loginSuccess(String result);

    }






}
