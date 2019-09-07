package inetSample.inetSocketclass;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class InetSocketDemo {
    public static void main(String[] args) {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1",9999);

        String name = address.getHostName();
        int port = address.getPort();
        System.out.println(name);
        System.out.println(port);
        System.out.println(address.getHostString());
        InetAddress inetAddress = address.getAddress();
        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());
//192.168.10.203

    }
}
