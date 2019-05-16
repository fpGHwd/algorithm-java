package com.itcast.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class LoginClient{
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 10008);

        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter pw = new PrintWriter(s.getOutputStream(), true); // true

        BufferedReader bufr1 = new BufferedReader(new InputStreamReader(s.getInputStream()));

        for(int i =0; i< 3; i++){
            String line = bufr.readLine();
            if(line == null)break; // control +c or network
            pw.println(line);

            String b = bufr1.readLine();
            System.out.println(b);
            if(b.contains("欢迎"))break;
        }

//        String str;
//        while((str = bufr.readLine())!=null){
//            pw.println(str);
//            String b = bufr1.readLine();
//            System.out.println(b);
//            if(b.contains("欢迎"))break;
//        }
//        System.out.println();

        bufr.close();
        s.close();


    }
}

class LoginHandle implements Runnable{
    private Socket s;
    LoginHandle(Socket s){
        this.s = s;
    }
    public void run(){
        try{
            System.out.println(s.getInetAddress().getHostName()+ ".......connected");

            BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));



            PrintWriter pw = new PrintWriter(s.getOutputStream(),true); // true

            String name;
            for(int i = 0; i < 3 ; i++){
                name = bufr.readLine();
                if(name == null)break;

                String r;
                boolean flag = false;

                BufferedReader bufr1 = new BufferedReader(new InputStreamReader(new FileInputStream("res/p308-namelist.file")));  // 不能读取一遍文件，每一个r对应都要检查一遍要读的文件。
                while((r = bufr1.readLine())!=null){ // todo: 要重新读取文件
                    if(name.equals(r)){
                        flag = true;
                        break;
                    }
                }

                if(flag)pw.println("欢迎"+name + ",登录成功");
                else pw.println(name + "：尝试登录");

            }

            s.close(); // 自动关闭流
        }catch(Exception e){
            System.out.println("登录出现异常");
        }
    }
}

class LoginServer{
    public static void main(String[] args) throws  IOException{
        ServerSocket ss = new ServerSocket(10008);
        Socket s;
        while((s = ss.accept())!=null){
            new Thread(new LoginHandle(s)).start();
        }
    }
}

public class p308 {
}
