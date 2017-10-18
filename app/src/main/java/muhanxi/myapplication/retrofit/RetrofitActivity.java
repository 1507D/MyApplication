package muhanxi.myapplication.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import muhanxi.myapplication.R;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static android.R.attr.path;

public class RetrofitActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);


        Retrofit retrofit = new Retrofit.Builder()
//                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://qhb.2dyt.com/")
                .validateEagerly(true)
                .build();


        GitHubService gitHubService =  retrofit.create(GitHubService.class);

//        Call<LoginBean> call =  gitHubService.login("Bwei");

//        Call<LoginBean> call = gitHubService.queryLogin("muhanxi","1507d","1111");

        Call<LoginBean> call =  gitHubService.queryLoginEagerly("11","1","1111");

        Map<String,String> map = new HashMap<String,String>();
        map.put("username","muhanxi");
        map.put("password","1111");
        map.put("postkey","1503d");

//        Call<LoginBean> call = gitHubService.postBodyLogin(new Bean("111","nuhanxi","1507d"));



        call.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                System.out.println("response = " + response.body());
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {

            }
        });





    }


    /**
     * 上传图片
     * @param path
     */
    public void uploadImage(String path){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://qhb.2dyt.com/")
                .build();

        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), new File(path));


        MultipartBody body = new MultipartBody.Builder()
                .addFormDataPart("key","value")
                .addFormDataPart("key1","value",requestBody)
                .build();


        GitHubService gitHubService =  retrofit.create(GitHubService.class);

        Call<LoginBean>  call =  gitHubService.uploadImage(body);


        call.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {

            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {

            }
        });
    }

}
