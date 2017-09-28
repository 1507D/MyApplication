package muhanxi.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import muhanxi.myapplication.mvc.Main3Activity;
import muhanxi.myapplication.mvp.Main4Activity;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.os.Build.VERSION_CODES.O;
import static java.nio.file.attribute.AclEntry.newBuilder;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        findViewById(R.id.photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                toPhoto();
            }
        });


        findViewById(R.id.camear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                toCamera();
            }
        });



//        cache();

        startActivity(new Intent(this, Main4Activity.class));

//        synchronousMethod();

//        asynchronousGet();

//        postString();

    }


    public void synchronousMethod(){


        new Thread(new Runnable() {
            @Override
            public void run() {


                try {
                    OkHttpClient client = new OkHttpClient();


                    Request request = new Request.Builder().url("https://publicobject.com/helloworld.txt").build();


                    Call call =  client.newCall(request);

                    //同步
                    Response response =  call.execute() ;


                    if(response.isSuccessful()){


                        ResponseBody body =  response.body() ;
                        String result =  body.string() ;

                        System.out.println("result = " + result);

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        }).start();



    }




























    public void asynchronousGet(){


       // http://www.baidu.com/aaaa/
        // http://www.baidu1.com/aaaa/
        // http://www.baidu.com/aaaa/

        // http://www.baidu2.com/aaaa/



        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://publicobject.com/helloworld.txt")
                    .header("key","value")
                    .header("key","value1")
                    .addHeader("Connection","Keep-Alive")
                    .addHeader("Connection","Keep-Alive1")
                    .build();


            Call call =  client.newCall(request);

             call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {


                   String result =   response.body().string() ;
                    System.out.println("result = " + result);

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static final MediaType MEDIA_TYPE_MARKDOWN
            = MediaType.parse("text/x-markdown; charset=utf-8");


    public void postString(){


        new Thread(new Runnable() {
            @Override
            public void run() {

                try {


                    File file = new File("本地图片路径");


                    OkHttpClient client = new OkHttpClient();

                    Request request = new Request.Builder().url("https://api.github.com/markdown/raw")
                            .post(RequestBody.create(MEDIA_TYPE_MARKDOWN,file))
                            .build();

                    Response response =   client.newCall(request).execute();


                    if(response.isSuccessful()){
                        String result =   response.body().string() ;
                        System.out.println("result = " + result);



                    }



                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        }).start();




    }


    /**
     * file 需要上传的照片
     * @param file
     * "path":"/usr/local/apache-tomcat-8.0.36/webapps/Bwei/upload/1506495879822face.jpg"
     * http://qhb.2dyt.com/Bwei/upload/1506495879822face.jpg
     *
     *  android.os.FileUriExposedException: file:///storage/emulated/0/dliao/1506496023937face.jpg exposed beyond app through ClipData.Item.getUri()
    09-27 15:07:03.944 15942-15942/muhanxi.myapplication W/System.err:     at android.os.StrictMode.onFileUriExposed(StrictMode.java:1799)
    09-27 15:07:03.944 15942-15942/muhanxi.myapplication W/System.err:     at android.net.Uri.checkFileUriExposed(Uri.java:2346)
    09-27 15:07:03.945 15942-15942/muhanxi.myapplication W/System.err:     at android.content.ClipData.prepareToLeaveProcess(ClipData.java:845)
    09-27 15:07:03.946 15942-15942/muhanxi.myapplication W/System.err:     at android.content.Intent.prepareToLeaveProcess(Intent.java:9044)
    09-27 15:07:03.947 15942-15942/muhanxi.myapplication W/System.err:     at android.content.Intent.prepareToLeaveProcess(Intent.java:9029)
    09-27 15:07:03.948 15942-15942/muhanxi.myapplication W/System.err:     at android.app.Instrumentation.execStartActivity(Instrumentation.java:1525)
    09-27 15:07:03.948 15942-15942/muhanxi.myapplication W/System.err:     at android.app.Activity.startActivityForResult(Activity.java:4361)
    09-27 15:07:03.949 15942-15942/muhanxi.myapplication W/System.err:     at android.app.Activity.startActivityForResult(Activity.java:4319)
    09-27 15:07:03.950 15942-15942/muhanxi.myapplication W/System.err:     at muhanxi.myapplication.MainActivity.toCamera(MainActivity.java:316)
    09-27 15:07:03.950 15942-15942/muhanxi.myapplication W/System.err:     at muhanxi.myapplication.MainActivity$2.onClick(MainActivity.java:56)
    09-27 15:07:03.951 15942-15942/muhanxi.myapplication W/System.err:     at android.view.View.performClick(View.java:5642)
    09-27 15:07:03.951 15942-15942/muhanxi.myapplication W/System.err:     at android.view.View$PerformClick.run(View.java:22485)
    09-27 15:07:03.952 15942-15942/muhanxi.myapplication W/System.err:     at android.os.Handler.handleCallback(Handler.java:751)
    09-27 15:07:03.952 15942-15942/muhanxi.myapplication W/System.err:     at android.os.Handler.dispatchMessage(Handler.java:95)
    09-27 15:07:03.953 15942-15942/muhanxi.myapplication W/System.err:     at android.os.Looper.loop(Looper.java:154)
    09-27 15:07:03.953 15942-15942/muhanxi.myapplication W/System.err:     at android.app.ActivityThread.main(ActivityThread.java:6209)
    09-27 15:07:03.954 15942-15942/muhanxi.myapplication W/System.err:     at java.lang.reflect.Method.invoke(Native Method)
    09-27 15:07:03.954 15942-15942/muhanxi.myapplication W/System.err:     at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:900)
    09-27 15:07:03.955 15942-15942/muhanxi.myapplication W/System.err:     at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:790)
     *
     */
    public void postFile(File file){



        //  sdcard/dliao/aaa.jpg
        String path =  file.getAbsolutePath() ;

        String [] split =  path.split("\\/");


       MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");


        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
//                file
                .addFormDataPart("imageFileName",split[split.length-1])
                .addFormDataPart("image",split[split.length-1],RequestBody.create(MEDIA_TYPE_PNG,file))
                .build();



        Request request = new Request.Builder().post(requestBody).url("http://qhb.2dyt.com/Bwei/upload").build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                System.out.println("response = " + response.body().string());

            }
        });



    }





    static final int INTENTFORCAMERA = 1 ;
    static final int INTENTFORPHOTO = 2 ;


    public String LocalPhotoName;
    public String createLocalPhotoName() {
        LocalPhotoName = System.currentTimeMillis() + "face.jpg";
        return  LocalPhotoName ;
    }

    public void toCamera(){
        try {
            Intent intentNow = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            Uri uri = null ;
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {  //针对Android7.0，需要通过FileProvider封装过的路径，提供给外部调用
//                uri = FileProvider.getUriForFile(UploadPhotoActivity.this, "com.bw.dliao", SDCardUtils.getMyFaceFile(createLocalPhotoName()));//通过FileProvider创建一个content类型的Uri，进行封装
//            }else {
                uri = Uri.fromFile(SDCardUtils.getMyFaceFile(createLocalPhotoName())) ;
//            }
            intentNow.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            startActivityForResult(intentNow, INTENTFORCAMERA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    /**
     * 打开相册
     */
    public void toPhoto(){
        try {
            createLocalPhotoName();
            Intent getAlbum = new Intent(Intent.ACTION_GET_CONTENT);
            getAlbum.setType("image/*");
            startActivityForResult(getAlbum, INTENTFORPHOTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case INTENTFORPHOTO:
                //相册
                try {
                    // 必须这样处理，不然在4.4.2手机上会出问题
                    Uri originalUri = data.getData();
                    File f = null;
                    if (originalUri != null) {
                        f = new File(SDCardUtils.photoCacheDir, LocalPhotoName);
                        String[] proj = {MediaStore.Images.Media.DATA};
                        Cursor actualimagecursor =  this.getContentResolver().query(originalUri, proj, null, null, null);
                        if (null == actualimagecursor) {
                            if (originalUri.toString().startsWith("file:")) {
                                File file = new File(originalUri.toString().substring(7, originalUri.toString().length()));
                                if(!file.exists()){
                                    //地址包含中文编码的地址做utf-8编码
                                    originalUri = Uri.parse(URLDecoder.decode(originalUri.toString(),"UTF-8"));
                                    file = new File(originalUri.toString().substring(7, originalUri.toString().length()));
                                }
                                FileInputStream inputStream = new FileInputStream(file);
                                FileOutputStream outputStream = new FileOutputStream(f);
                                copyStream(inputStream, outputStream);
                            }
                        } else {
                            // 系统图库
                            int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                            actualimagecursor.moveToFirst();
                            String img_path = actualimagecursor.getString(actual_image_column_index);
                            if (img_path == null) {
                                InputStream inputStream = this.getContentResolver().openInputStream(originalUri);
                                FileOutputStream outputStream = new FileOutputStream(f);
                                copyStream(inputStream, outputStream);
                            } else {
                                File file = new File(img_path);
                                FileInputStream inputStream = new FileInputStream(file);
                                FileOutputStream outputStream = new FileOutputStream(f);
                                copyStream(inputStream, outputStream);
                            }
                        }
                        Bitmap bitmap = ImageResizeUtils.resizeImage(f.getAbsolutePath(), 1080);
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        FileOutputStream fos = new FileOutputStream(f.getAbsolutePath());
                        if (bitmap != null) {

                            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 85, fos)) {
                                fos.close();
                                fos.flush();
                            }
                            if (!bitmap.isRecycled()) {
                                bitmap.isRecycled();
                            }

                            System.out.println("f = " + f.length());
                            postFile(f);

                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();

                }


                break;
            case INTENTFORCAMERA:
//                相机
                try {

                    //file 就是拍照完 得到的原始照片
                    File file = new File(SDCardUtils.photoCacheDir, LocalPhotoName);
                    Bitmap bitmap = ImageResizeUtils.resizeImage(file.getAbsolutePath(), 1080);
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());
                    if (bitmap != null) {
                        if (bitmap.compress(Bitmap.CompressFormat.JPEG, 85, fos)) {
                            fos.close();
                            fos.flush();
                        }
                        if (!bitmap.isRecycled()) {
                            //通知系统 回收bitmap
                            bitmap.isRecycled();
                        }
                        System.out.println("f = " + file.length());

                        postFile(file);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }



                break;
        }






    }












    public static void copyStream(InputStream inputStream, OutputStream outStream) throws Exception {
        try {
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            outStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                inputStream.close();
            }
            if(outStream != null){
                outStream.close();
            }
        }

    }



    public void post(){


        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new FormBody.Builder()
                .add("username","1507D")
                .add("password","1507D")
                .add("postkey","1503")
                .build();


        Request request = new Request.Builder().url("http://qhb.2dyt.com/Bwei/login")
                .post(requestBody).build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                System.out.println("response = " + response.body().string());

            }
        });




    }




    public void cache(){

        new Thread(new Runnable() {
            @Override
            public void run() {




                try {


                    int cacheSize = 10 * 1024 * 1024; // 10 MiB
                    Cache cache = new Cache(getCacheDir(), cacheSize);

                    OkHttpClient client = new OkHttpClient.Builder()
                            .addInterceptor(new LoggingInterceptor())
                            .cache(cache)
                            .build();
                    Request request = new Request.Builder()
                            .cacheControl(CacheControl.FORCE_NETWORK)
                            .url("http://publicobject.com/helloworld.txt")
                            .build();

                    String response1Body;
                    Response response1 = client.newCall(request).execute();
//        () {
                    if (!response1.isSuccessful()) throw new IOException("Unexpected code " + response1);

                    response1Body = response1.body().string();
                    System.out.println("Response 1 response:          " + response1);
                    System.out.println("Response 1 cache response:    " + response1.cacheResponse());
                    System.out.println("Response 1 network response:  " + response1.networkResponse());
//        }

                    String response2Body;
//
// {
//                    Response response2 = client.newCall(request).execute();
//
//
////                   Call call1 =   client.newCall(request);
////
////                    call1.cancel();
//
//                    if (!response2.isSuccessful()) throw new IOException("Unexpected code " + response2);
//
//                    response2Body = response2.body().string();
//                    System.out.println("Response 2 response:          " + response2);
//                    System.out.println("Response 2 cache response:    " + response2.cacheResponse());
//                    System.out.println("Response 2 network response:  " + response2.networkResponse());
//
//
//                    System.out.println("Response 2 equals Response 1? " + response1Body.equals(response2Body));
//


                }catch (Exception e) {

                }


            }
        }).start();



    }


    //
    public void percall(){



        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).build();

        OkHttpClient client1 = client.newBuilder().connectTimeout(10, TimeUnit.SECONDS).build();

        OkHttpClient client2 = client.newBuilder().connectTimeout(100, TimeUnit.SECONDS).build();

//        client.newCall()


    }




}
