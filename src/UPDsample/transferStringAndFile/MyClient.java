package UPDsample.transferStringAndFile;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MyClient {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("baidu.html"),UTF_8));
        //Create socket
        DatagramSocket client = new DatagramSocket(6666);
        //Create container

/*        String msg = "Message from clint";
        byte[] container = msg.getBytes();*/

        StringBuilder stringBuilder = new StringBuilder("");
        String line = null;
        while(null!=(line=reader.readLine())){
            stringBuilder.append(line);
        }
/*        byte[] container = new byte[1024];
        int load = 0;*/
        //Pack up with data and target socket
        DatagramPacket packet = new DatagramPacket(stringBuilder.toString().getBytes(),stringBuilder.toString().getBytes().length,new InetSocketAddress("localhost",8888));
        //DatagramPacket packet = new DatagramPacket(container,container.length,new InetSocketAddress("localhost",8888));
        //send package
        client.send(packet);
        //release resource
        client.close();

    }
}
