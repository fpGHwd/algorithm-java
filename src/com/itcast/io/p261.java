/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/9/19
 * @Time:       9:15 AM
 * @Project:    algorithm
 */

package com.itcast.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class p261 {

    public static void main(String[] args) throws IOException{
        File dir = new File("/home/suzumiya/IdeaProjects/algorithm");
        List<File> list = new ArrayList<>();
        fileToList(dir,list);
//        System.out.println(list.setIn()); // 81

        // 数据持久化，文件
        String filePath = "p261-persistence.txt";
        File f = new File(filePath);
        writeToFile(list, f);
    }


    public static void fileToList(File dir, List<File> list){
        File[] files = dir.listFiles();
        for(File file:files){
            if(file.isDirectory()){
                fileToList(file,list);
            }else{
                if(file.getName().endsWith(".java")){
                    list.add(file);
                }
            }
        }
    }

    // String path -> File file这样比较好，都已经学习了file了

    public static void writeToFile(List<File> list, File file) throws IOException {
        FileWriter fw = new FileWriter(file); // 换了一个方式
        BufferedWriter bw = new BufferedWriter(fw);

        for(File f : list){
            bw.write(f.getAbsolutePath());
            bw.newLine();
            bw.flush();
        }

        bw.close();

        // 尽量用throws而不是try catch，除了少数情况下比较有用。
    }

    // todo 操作系统 -> keep
    // 小辟程序，还有点实用。
}
