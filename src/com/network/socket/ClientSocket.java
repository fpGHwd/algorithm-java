/**
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       11:11 AM
 * @Project:    algorithm
 */

package com.network.socket;

//自从序列化成熟以后，取名字也以简洁明了为主了。感觉自己的系统正在变大。
// 比如如果这里的话用Client的话也是没有问题的，自己也不会纠结了。
// 给任何东西去取好自己喜欢的名字是扩大自己系统的第一步。当然这个好要是你自己觉得的好。

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

public class ClientSocket {

    @Test
    public void test(){
        Socket s;
        try {
            s = new Socket("time.nist.gov", 13);
            s.setSoTimeout(15000);
            InputStream in = s.getInputStream();
            StringBuilder sb = new StringBuilder();
            InputStreamReader isr = new InputStreamReader(in, "ASCII");
            for(int c = isr.read(); c!= -1; c= isr.read()){
                sb.append((char)c);
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

    }

    @Test
    public void testConstructASocket(){
        try {
            Socket s = new Socket("www.oreilly.com", 80);
            System.out.println("Connect successfully");
            System.out.println(s);
        } catch (UnknownHostException ue) {
//            ue.printStackTrace();
            System.err.println(ue);
        }catch (IOException ioe){
            System.err.println(ioe);
        }finally{

        }
    }

    @Test
    public void testIfTCPServerBeforePortRangeIn1024(){
        String host = "d404.autove.dev";
        String hc = "cathy.autove.dev";
        for(int p = 1; p <= 1024; p++){
            try {
                Socket s = new Socket(hc, p);
                System.out.println("there is a server on port " + p + ":" +  host);
                s.close();
            } catch (UnknownHostException e) {
//                e.printStackTrace();
                System.out.println(e);
                break;
            }catch (IOException ioe){
                // 这个端口上不是一个服务器
                System.out.println("NO server on port " + p + ":" +  host);
            }
        }
    }

    @Test
    public void testGetAddress(){
        String h = "cathy.autove.dev";
        Selector sl = new Selector() {
            @Override
            public boolean isOpen() {
                return false;
            }

            @Override
            public SelectorProvider provider() {
                return null;
            }

            @Override
            public Set<SelectionKey> keys() {
                return null;
            }

            @Override
            public Set<SelectionKey> selectedKeys() {
                return null;
            }

            @Override
            public int selectNow() throws IOException {
                return 0;
            }

            @Override
            public int select(long timeout) throws IOException {
                return 0;
            }

            @Override
            public int select() throws IOException {
                return 0;
            }

            @Override
            public Selector wakeup() {
                return null;
            }

            @Override
            public void close() throws IOException {

            }
        };
        try {
            Socket s = new Socket(h, 61000);
            SocketAddress sa = s.getRemoteSocketAddress();
            System.out.println(sa);
//            s.close(); // 里面果然是有判断的，判断一个flag，本质也是判断
        } catch (IOException e) {
            e.printStackTrace();
        } // 自动关闭了
    }


    // 将缓冲区大小设置🉐过高，程序会试图以过高的速度发送和接收数据，而网络来不及处理，这就会导致拥塞、丢包和性能下降。
    // 因此，要得到最大带宽，需要让缓冲区大小与连接的延迟匹配，使它稍小于网络的带宽。
    // 匹配这个词就是核心啊。

    // 把计算机的那些事情和生活中的事情联系起来看的话，就很好理解了。其实还是抽象能力的提高。
    // 当然，我还要带着这个利器去看 深入理解计算机组成原理。

}
