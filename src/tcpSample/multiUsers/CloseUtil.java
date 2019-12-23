package tcpSample.multiUsers;

import java.io.Closeable;
import java.io.IOException;

/*
* Close stream;
* */
public class CloseUtil {
    public static void closeAll(Closeable...io){
        for(Closeable temp:io){
            if(null!=temp){
                try {
                    temp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
