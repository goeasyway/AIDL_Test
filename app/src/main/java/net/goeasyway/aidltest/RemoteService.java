package net.goeasyway.aidltest;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;

import net.goeasyway.aidltest.diy.Stub;

public class RemoteService extends Service {
    public RemoteService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder; //暴露给客户端
    }

//    public class MyBinder extends Binder {
//
//    }

    // 实现AIDL接口
    private final Stub binder = new Stub() {

        @Override
        public int getPid() throws RemoteException {
            return Process.myPid();
        }

//        @Override
//        public MyProcess getProcess(MyProcess clientProcess) throws RemoteException {
//            MyProcess process = new MyProcess(Process.myPid(), getCurProcessName(RemoteService.this));
//            return process;
//        }
//
//        @Override
//        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//                               double aDouble, String aString) throws RemoteException {
//
//        }
    };

    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }

}
