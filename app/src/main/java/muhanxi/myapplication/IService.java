package muhanxi.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by muhanxi on 17/10/9.
 */

public class IService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("tag","IApplication IService onCreate");

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
