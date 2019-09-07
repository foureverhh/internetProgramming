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
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(client.getInputStream());

        while(true) {
            String info = console.readLine();
            //Output data 输出流
            dataOutputStream.writeUTF(info);
            dataOutputStream.flush();
            //Input data 输入流
            String inputMessage = dataInputStream.readUTF();
            System.out.println("Client 输入流内容： " + inputMessage);
        }
    }
}
