package net.goeasyway.aidltest.diy;

/**
 * Created by lan on 17/2/14.
 */

/** Local-side IPC implementation stub class. */
public  abstract class Stub extends android.os.Binder implements IRemote
{

    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
        this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an net.goeasyway.aidltest.IRemote interface,
     * generating a proxy if needed.
     */
    public static IRemote asInterface(android.os.IBinder obj)
    {
        if ((obj==null)) {
            return null;
        }
        android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
        if (((iin!=null)&&(iin instanceof IRemote))) {
            return ((IRemote)iin);
        }
        return new Proxy(obj);
    }

    @Override
    public android.os.IBinder asBinder()
    {
        return this;
    }

    @Override
    public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
        switch (code)
        {
            case INTERFACE_TRANSACTION:
            {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            case TRANSACTION_getPid:
            {
                data.enforceInterface(DESCRIPTOR);
                int _result = this.getPid();
                reply.writeNoException();
                reply.writeInt(_result);
                return true;
            }
        }
        return super.onTransact(code, data, reply, flags);
    }


}
