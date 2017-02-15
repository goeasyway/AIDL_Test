package net.goeasyway.aidltest.diy;

/**
 * Created by lan on 17/2/14.
 */

public class Proxy implements IRemote
{
    private android.os.IBinder mRemote;

    Proxy(android.os.IBinder remote)
    {
        mRemote = remote;
    }

    @Override
    public android.os.IBinder asBinder()
    {
        return mRemote;
    }

    public java.lang.String getInterfaceDescriptor()
    {
        return DESCRIPTOR;
    }

    @Override
    public int getPid() throws android.os.RemoteException
    {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int _result;
        try {
            _data.writeInterfaceToken(DESCRIPTOR);
            mRemote.transact(TRANSACTION_getPid, _data, _reply, 0);
            _reply.readException();
            _result = _reply.readInt();
        }
        finally {
            _reply.recycle();
            _data.recycle();
        }
        return _result;
    }

}