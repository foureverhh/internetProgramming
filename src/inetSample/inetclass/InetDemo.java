package inetSample.inetclass;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
        System.out.println(Arrays.toString(address.getAddress()));


        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        System.out.println("Baidu IP is: "+baidu.getHostAddress());
        System.out.println("Baidu host name is: "+baidu.getHostName());

    }
}
