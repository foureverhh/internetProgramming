package tcpSample.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
/*
*
*
* 3.发送和接收数据
*
* */
public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务器，指定端口ServerSocket (int port)
        ServerSocket server = new ServerSocket(8888);
        //端口接收客户端连接，阻塞式
        Socket socket = server.accept();//This socket is the reference of socket of client
        System.out.println("与一个客户端建立连接");
        String msgFromServer = "Message from server";
        //输出流
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write(msgFromServer);
        writer.flush();




    }
}
