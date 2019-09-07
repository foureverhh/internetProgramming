package tcpSample.multiThreadChatRoom;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
* Make a server can send and accept data
* */
public class Server {
    public static void main(String[] args) throws IOException {
        //Create Server
        ServerSocket server = new ServerSocket(7777);
        Socket client = server.accept();
        //Connect server to client
        DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());

        while (true){
            //Input data 输入流
            String message = dataInputStream.readUTF();
            System.out.println("Info from client: "+message);

            //Output data 输出流
            dataOutputStream.writeUTF("Server -->" + message);
            dataOutputStream.flush();
        }
    }
}
