package com.jiakang.tomcat;

import java.io.*;

public class Response {
    public  static final int BUFFER_SIZE = 2048;
    //浏览器访问D盘的文件
    private static final String WEB_ROOT = "D:";
    private Request request;
    private OutputStream output;

    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
public void sendStaticResource(){
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            //拼接本地目录和浏览器端口号后面的目录
            File file = new File(WEB_ROOT, request.getUrl());
            //如果文件存在，且不是个目录
            if (file.exists() && !file.isDirectory()) {
                fis = new FileInputStream(file);
                int ch = fis.read(bytes,0,BUFFER_SIZE);
                while (ch != -1){
                    output.write(bytes,0,ch);
                    ch = fis.read(bytes,0,BUFFER_SIZE);
                }
            }else{
                //文件不存在，返回给浏览器响应提示，这里可以拼接HTML任何元素;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
