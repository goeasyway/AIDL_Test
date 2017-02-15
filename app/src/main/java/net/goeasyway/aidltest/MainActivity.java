package net.goeasyway.aidltest;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import net.goeasyway.aidltest.diy.IRemote;
import net.goeasyway.aidltest.diy.Stub;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";
    private IRemoteService remoteService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        intent.setClass(this, RemoteService.class);
        bindService(intent, connection, Service.BIND_AUTO_CREATE); // 绑定服务
    }

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IRemote remoteService = Stub.asInterface(service);
            Log.i(TAG, "Client pid= " + Process.myPid());
            try {
                Log.i(TAG, "RemoteService pid= " + remoteService.getPid());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


//    private ServiceConnection connection = new ServiceConnection() {
//        public void onServiceConnected(ComponentName className, IBinder service) {
//            remoteService = IRemote.Stub.asInterface(service); //获取AIDL的接口实现引用
//            try {
//                MyProcess clientProcess = new MyProcess(Process.myPid(), MainActivity.this.getPackageName());
//                MyProcess myProcess = remoteService.getProcess(clientProcess);
//                Log.i(TAG, "RemoeteService pName = " + myProcess.name);
//                Log.i(TAG, "RemoteService pid= " + myProcess.pid);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public void onServiceDisconnected(ComponentName className) {
//            Log.e(TAG, "Service has unexpectedly disconnected");
//            remoteService = null;
//        }
//    };
}
