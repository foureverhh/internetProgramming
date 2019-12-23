package tcpSample.multiUsers;

import tcpSample.multiThreadChatRoom.CloseUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


/*
* 发送数据线程
* */
public class Send implements Runnable{
    private BufferedReader console;
    private DataOutputStream dataOutputStream;
    private boolean isRunning = true;


    public Send(){
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    public Send(Socket client)  {
        this();
        try {
            dataOutputStream = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.closeAll(dataOutputStream,console);
        }
    }
    //1.1.从控制台接收数据
    private String getInfoFromConsole(){
        try {
            return console.readLine();
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return "";
    }

    /*
    * 1.从控制台接收数据
    * 2.发送数据
    * */
    public void send(){
        String message = getInfoFromConsole();
        if(null!= message && !message.equals("")){
            try {
                dataOutputStream.writeUTF(message);
                System.out.println("Client send -> "+message);
                dataOutputStream.flush();
            } catch (IOException e) {
                isRunning = false;
                CloseUtil.closeAll(dataOutputStream,console);
            }
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            send();
        }
    }
}
