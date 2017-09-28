package muhanxi.myapplication;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

class LoggingInterceptor implements Interceptor {
  @Override public Response intercept(Interceptor.Chain chain) throws IOException {
    Request request = chain.request();

    long t1 = System.currentTimeMillis();


    Response response = chain.proceed(request);

    long t2 = System.currentTimeMillis();

    System.out.println("t2 = " +( t2-t1));


    return response;
  }
}