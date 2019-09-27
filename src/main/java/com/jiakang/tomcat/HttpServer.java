package com.jiakang.tomcat;





import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class HttpServer {
    //用户判断是否关闭容器
    private boolean shutdown = false;

    public void acceptWati(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080,1,InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while(!shutdown){
            try {
                Socket socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                //接受请求参数
                Request request = new Request(os);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }



    public static void main(String[] args) throws UnknownHostException {
        System.out.println(InetAddress.getByName("PC1"));
    }
}
