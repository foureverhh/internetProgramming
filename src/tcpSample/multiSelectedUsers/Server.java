package tcpSample.multiSelectedUsers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*
* Make a server can send and accept data
* */
public class Server {
    private List<MyChannel> allChannels = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        new Server().startChatting();
    }

    public void startChatting() throws IOException {
        //Create Server
        ServerSocket server = new ServerSocket(7777);
        while (true) {
            Socket client = server.accept();
            MyChannel newChannel = new MyChannel(client);
            allChannels.add(newChannel);
            new Thread(newChannel).start();//一条通道（一个客户端）
        }
    }

    /*
     *对一个客户端的一条道路
     *
     */
    private class MyChannel implements Runnable {
        private DataInputStream dis;
        private DataOutputStream dos;
        private boolean isRunning = true;

        public MyChannel(Socket client){
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                CloseUtil.closeAll(dis);
                isRunning = false;
                System.out.println(".......................");
                allChannels.remove(this);//移除自身
            }
        }

        private String receiveData(){
            String message = "";
            try {
                message = dis.readUTF();
                System.out.println("Server receive -> "+message);
            } catch (IOException e) {
                CloseUtil.closeAll(dis);
                isRunning = false;
                System.out.println("******************************");
                allChannels.remove(this);//移除自身
            }
            return message;
        }
        private void sendDataToOthers(){
            String message = receiveData();
            for(MyChannel channel: allChannels){

                if(channel != this){
                    //Send message to other channels
                    channel.sendData(message);
                }
            }
        }
        private void sendData(String message){
            if(message==null || message.equals(""))
                return;
            try{
                dos.writeUTF(message);
                System.out.println("Server send out -> "+message);
                dos.flush();
            } catch (IOException e) {
                CloseUtil.closeAll(dis);
                isRunning = false;
                System.out.println("////////////////////////////");
                allChannels.remove(this);//移除自身
            }finally {
                if(null!=dos){
                    try {
                        dos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        @Override
        public void run() {
            while(isRunning){
                sendDataToOthers();
            }
        }
    }

}



