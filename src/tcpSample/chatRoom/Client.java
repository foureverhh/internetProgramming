package tcpSample.chatRoom;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*
* Create client to send and receive info
* send: client.getOutputStream()
* */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",6666);

        //Console to input
        System.out.println("Input what you want:");
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String info = console.readLine();


        //Output data 输出流
        DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
        dataOutputStream.writeUTF(info);
        dataOutputStream.flush();
        //Input data 输入流
        DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
        String inputMessage = dataInputStream.readUTF();
        System.out.println("Client 输入流内容： "+inputMessage);
    }
}
