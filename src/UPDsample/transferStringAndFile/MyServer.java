package UPDsample.transferStringAndFile;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
* 1 创建服务端 + 端口
* 2 准备接收容器
* 3 封装包
* 4 接收包
* 5 分析包
* 6 释放服务端
* */
public class MyServer {
    public static void main(String[] args) throws IOException {
        //创建服务端+端口
        DatagramSocket server = new DatagramSocket(8888);
        //准备接收容器
        byte[] container = new byte[1024];
        //封装包
        DatagramPacket packet = new DatagramPacket(container,container.length);
        //服务端口接收包
        server.receive(packet);
        //服务端口分析包
        byte[] data = packet.getData();
        int len = packet.getLength();
        System.out.println(new String(data,0,len));


    }
}
