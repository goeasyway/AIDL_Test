// IRemoteService.aidl
package net.goeasyway.aidltest;

import net.goeasyway.aidltest.MyProcess;

interface IRemoteService {
    /**
     * Request the process ID of this service, to do evil things with it.
     * */
    int getPid();

    MyProcess getProcess(in MyProcess clientProcess);

    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
