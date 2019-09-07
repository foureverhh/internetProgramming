package UPDsample.transferDouble;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {
        //Create socket
        DatagramSocket server = new DatagramSocket(8888);

        //Create byte[] container
        byte[] container = new byte[1024];

        //Create package to receive data
        DatagramPacket packet = new DatagramPacket(container,container.length);

        //Server receive packet
        server.receive(packet);

        //Handle the received data in packet
        byte[] data = packet.getData();

      //Convert byte[] to double
        DataInputStream dataInputStream = new DataInputStream( new ByteArrayInputStream(data));
        double d = dataInputStream.readDouble();

        System.out.println("Server get number of double as: "+d);

        server.close();

    }

    public static double convert(byte[] data) throws IOException {

        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(bis);
        double num = dis.readDouble();
        dis.close();
        return num;
    }
}
