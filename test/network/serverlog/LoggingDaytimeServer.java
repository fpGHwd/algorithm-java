/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       1:21 PM
 * @Project:    algorithm
 */

package network.serverlog;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingDaytimeServer {

    public final static int PORT = 61000;
    private static Logger auditLogger = Logger.getLogger("requests");
    private static Logger errorLogger = Logger.getLogger("errors");
    private static LogManager lm = LogManager.getLogManager();

    public static void main(String[] args){

        try{
            InputStream is = ClassLoader.getSystemResourceAsStream("network/serverlog/logging.properties");
            // 如何加载logging的日志文件
            lm.readConfiguration(is);
            lm.addLogger(auditLogger);
            lm.addLogger(errorLogger);
        }catch (IOException ex){
            ex.printStackTrace();
        }catch (SecurityException ex){
            ex.printStackTrace();
        }finally {

        }

        ExecutorService pool = Executors.newFixedThreadPool(50);
        try(ServerSocket server  = new ServerSocket(PORT)){
            while(true){
                Socket connection = server.accept();
                Callable<Void> task = new DaytimeTask(connection);
                pool.submit(task);
            }
        }catch (IOException ex){
//            errorLogger.log(Level.SEVERE, "Couldn't start server", ex);
            errorLogger.severe("IOE: Couldn't start server" + ex);
        }catch(RuntimeException ex){
//            errorLogger.log(Level.SEVERE, "Couldn't start server: " + ex.getMessage() , ex);
            errorLogger.severe("RE: Couldn't start server" + ex);
        }
    }


    //
    private static class DaytimeTask implements Callable<Void>{
        private  Socket connection;

        public DaytimeTask(Socket connection){
            this.connection = connection;
        }

        // 要不要override无所谓，反正都是覆写
        public Void call() {

            try {
                Date now = new Date();
                auditLogger.info(now + " " + connection.getRemoteSocketAddress());
                Writer out = new OutputStreamWriter(connection.getOutputStream());
                out.write(now.toString() + "\r\n");
                out.flush();
            }catch (IOException ex){
                // 客户端断开连接，忽略
            }finally {
                try{
                    connection.close();
                }catch (IOException ex){
                    // 忽略
                }
            }
            return null;
        }
    }
}

