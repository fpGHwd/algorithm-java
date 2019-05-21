package com.io;

        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.nio.ByteBuffer;
        import java.nio.channels.FileChannel;

/**
 * 利用NIO通道完成文件复制
 */
public class TestChannel {
    public static void main(String[] args) {
        // 源文件
        File fromFile = new File("pom.xml");
        // 目标文件
        File toFile = new File("pom-copy.xml");

        try (
                // 根据源文件创建文件输入流
                FileInputStream fis = new FileInputStream(fromFile);
                // 根据目标文件创建文件输出流，如果文件不存在，自动创建
                FileOutputStream fos = new FileOutputStream(toFile);
                // 1. 获取通道
                FileChannel inChannel = fis.getChannel();
                FileChannel outChannel = fos.getChannel();
        ) {
            // 2. 分配指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(48);
            // 3. 将通道中的数据读取到缓冲区
            while (inChannel.read(buffer) != -1) {
                // 切换成读数据模式
                buffer.flip();
                // 4. 从缓冲区读取数据写入到通道中
                outChannel.write(buffer);
                // 清空缓冲区
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}