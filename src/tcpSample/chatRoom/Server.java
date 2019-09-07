package tcpSample.chatRoom;

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
        ServerSocket server = new ServerSocket(6666);
        //Connect server to client
        //while (true){
        Socket client = server.accept();
        //Input data 输入流
        DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
        String message = dataInputStream.readUTF();
        System.out.println("Info from client: "+message);


        //Output data 输出流
        DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
        dataOutputStream.writeUTF("Server -->" + message);
        dataOutputStream.flush();
        //}
    }
}
