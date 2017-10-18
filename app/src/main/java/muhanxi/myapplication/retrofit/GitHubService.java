package muhanxi.myapplication.retrofit;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by muhanxi on 17/10/11.
 */

public interface GitHubService {


//    login 是一个变量 可以动态改变
//    @GET 表示get请求
//    @Path 表示更换路径
    @GET("{login}/login?postkey=1503d&username=123&password=123")
    Call<LoginBean> login(@Path(value = "" , encoded =true ) String login);



//    Query 定义 参数
    @GET("Bwei/login")
    Call<LoginBean> queryLogin(@Query("username") String username,@Query("postkey") String postkey,@Query("password") String password);



    @GET("Bwei/login")
    Call<LoginBean> queryMapLogin(@QueryMap Map<String,String> map);




    // post
//    Field post请求 传递参数
    @FormUrlEncoded
    @POST("Bwei/login")
    Call<LoginBean> postFieldLogin(@Field("username") String username,@Field("postkey") String postkey,@Field("password") String password);



    @FormUrlEncoded
    @POST("Bwei/login")
    Call<LoginBean> postFieldMapLogin(@FieldMap Map<String,String> map);


    @POST("Bwei/login")
    Call<LoginBean> postBodyLogin(@Body Bean loginBean);


    @Headers("bwei:1507D")
    @POST("Bwei/upload")
    Call<LoginBean> uploadImage(@Part("image")MultipartBody multipartBody);



//    Call<RequestBody> uploadImage(@Part("image")MultipartBody multipartBody);

    @GET
    Call<ResponseBody> urlLogin(@Url String url);


    @GET
    Call<String> urlStringLogin(@Url String url);

    @GET("Bwei/login")
    Call<LoginBean> queryLoginEagerly(@Field("username") String username,@Field("postkey") String postkey,@Field("password") String password);



}
