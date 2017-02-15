package net.goeasyway.aidltest.diy;

/**
 * Created by lan on 17/2/5.
 */

public interface IRemote extends android.os.IInterface {
    public static final java.lang.String DESCRIPTOR = "net.goeasyway.aidltest.diy.IRemote";
    public static final int TRANSACTION_getPid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);

    public int getPid() throws android.os.RemoteException;
}
