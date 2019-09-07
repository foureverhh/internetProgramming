package tcpSample.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端
        Socket client = new Socket("localhost",9999);

        //接收来自服务端的数据
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String msgReceived = reader.readLine();
        System.out.println(msgReceived);
    }
}
