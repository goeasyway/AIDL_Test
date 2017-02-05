package net.goeasyway.aidltest;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 进程信息
 * Created by lan on 17/2/5.
 */
public class MyProcess implements Parcelable {

    public int pid;
    public String name;

    public MyProcess(int pid, String name) {
        this.pid = pid;
        this.name = name;
    }

    protected MyProcess(Parcel in) {
        readFromParcel(in);
    }

    public static final Creator<MyProcess> CREATOR = new Creator<MyProcess>() {
        @Override
        public MyProcess createFromParcel(Parcel in) {
            return new MyProcess(in);
        }

        @Override
        public MyProcess[] newArray(int size) {
            return new MyProcess[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel in) {
        pid = in.readInt();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(pid);
        dest.writeString(name);
    }
}
