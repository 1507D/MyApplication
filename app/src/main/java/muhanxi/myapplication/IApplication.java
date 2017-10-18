package muhanxi.myapplication;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.tencent.bugly.crashreport.CrashReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import muhanxi.myapplication.crash.CrashHandler;

/**
 * Created by muhanxi on 17/10/9.
 */

public class IApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


//        CrashHandler.getInstance().init(this);

        Log.e("tag","IApplication IApplication onCreate");

        Context context = getApplicationContext();
// 获取当前包名
        String packageName = context.getPackageName();
// 获取当前进程名
        String processName = getProcessName(android.os.Process.myPid());
        if(processName.equals(packageName)){
            CrashReport.initCrashReport(getApplicationContext(), "f10d837b88", true);
        }
// 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
//        strategy.set
//        strategy.setUploadProcess(processName == null || processName.equals(packageName));
// 初始化Bugly
//        CrashReport.initCrashReport(context, "注册时申请的APPID", isDebug, strategy);
// 如果通过“AndroidManifest.xml”来配置APP信息，初始化方法如下

        Logger.addLogAdapter(new AndroidLogAdapter());


    }


    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            Log.e("tag","IApplication getProcessName processName" + processName);


            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }
}
