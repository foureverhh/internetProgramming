package tcpSample.multiUsers;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable {
    private DataInputStream dataInputStream;
    private boolean isRunning = true;

    public Receive(){

    }
    public Receive(Socket client)  {
        try {
            dataInputStream = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.closeAll(dataInputStream);
        }
    }

    private String receive(){
        String message = "";
        try {
            message = dataInputStream.readUTF();
        } catch (IOException e) {
            CloseUtil.closeAll(dataInputStream);
            isRunning = false;
        }
        return message;
    }


    @Override
    public void run() {
        while(isRunning){
            System.out.println(receive());
        }
    }
}
