package UPDsample.transferDouble;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket(6666);
//        String message = "Message";
        //byte[] data = message.getBytes();
        double num = 18.91;
        byte[] data = convert(num);
        DatagramPacket packet = new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8888));
        client.send(packet);
        client.close();
    }

    public static byte[] convert(double number) throws IOException {
        byte[] data = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);

        dos.writeDouble(number);
        dos.flush();

        //Get data
        data = bos.toByteArray();
        dos.close();
        return data;
    }
}
