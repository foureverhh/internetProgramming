package tcpSample.multiUsers;

import java.io.IOException;
import java.net.Socket;

/*
* Create client to send and receive info
* send: client.getOutputStream()
* */
public class Client3 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",7777);
        new Thread(new Send(client)).start();
        new Thread(new Receive(client)).start();
    }
}
