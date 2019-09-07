package tcpSample.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
    public static void main(String[] args) throws IOException {
        //Create Server
        ServerSocket server = new ServerSocket(9999);
        while (true){
           Socket socket = server.accept();
           System.out.println("建立了一个client的链接");
           String msg = "message";
           BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
           writer.write(msg);
           writer.newLine();
           writer.flush();

        }

    }
}
