/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/13/19
 * @Time:       8:08 PM
 * @Project:    algorithm
 */

package com.itcast.collections.map;

import org.junit.Test;

import java.util.*;



public class p216 {

    @Test
    public void testProperties(){

        Properties p = System.getProperties();

//        System.out.println(p);

        for(Object obj: p.keySet()){
            String value = (String)p.get(obj);
            System.out.println((String)obj + ":" + value);
        }


        /**
         * java.runtime.name:Java(TM) SE Runtime Environment
         * sun.boot.library.path:/usr/lib/jvm/java-8-jdk/jre/lib/amd64
         * java.vm.version:25.202-b08
         * java.vm.vendor:Oracle Corporation
         * java.vendor.url:http://java.oracle.com/
         * path.separator::
         * java.vm.name:Java HotSpot(TM) 64-Bit Server VM
         * file.encoding.pkg:sun.io
         * user.country:US
         * sun.java.launcher:SUN_STANDARD
         * sun.os.patch.level:unknown
         * java.vm.specification.name:Java Virtual Machine Specification
         * user.dir:/home/suzumiya/IdeaProjects/algorithm
         * java.runtime.version:1.8.0_202-b08
         * java.awt.graphicsenv:sun.awt.X11GraphicsEnvironment
         * java.endorsed.dirs:/usr/lib/jvm/java-8-jdk/jre/lib/endorsed
         * os.arch:amd64
         * java.io.tmpdir:/tmp
         * line.separator:
         *
         * java.vm.specification.vendor:Oracle Corporation
         * os.name:Linux
         * sun.jnu.encoding:UTF-8
         * java.library.path:/usr/java/packages/lib/amd64:/usr/lib64:/lib64:/lib:/usr/lib
         * java.specification.name:Java Platform API Specification
         * java.class.version:52.0
         * sun.management.compiler:HotSpot 64-Bit Tiered Compilers
         * os.version:5.0.9-2-MANJARO
         * user.home:/home/suzumiya
         * user.timezone:
         * java.awt.printerjob:sun.print.PSPrinterJob
         * file.encoding:UTF-8
         * java.specification.version:1.8
         * java.class.path:/opt/intellij-idea-ultimate-edition/lib/idea_rt.jar:/opt/intellij-idea-ultimate-edition/plugins/junit/lib/junit-rt.jar:/opt/intellij-idea-ultimate-edition/plugins/junit/lib/junit5-rt.jar:/usr/lib/jvm/java-8-jdk/jre/lib/charsets.jar:/usr/lib/jvm/java-8-jdk/jre/lib/deploy.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/cldrdata.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/dnsns.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/jaccess.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/jfxrt.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/localedata.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/nashorn.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/sunec.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/sunjce_provider.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/sunpkcs11.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/zipfs.jar:/usr/lib/jvm/java-8-jdk/jre/lib/javaws.jar:/usr/lib/jvm/java-8-jdk/jre/lib/jce.jar:/usr/lib/jvm/java-8-jdk/jre/lib/jfr.jar:/usr/lib/jvm/java-8-jdk/jre/lib/jfxswt.jar:/usr/lib/jvm/java-8-jdk/jre/lib/jsse.jar:/usr/lib/jvm/java-8-jdk/jre/lib/management-agent.jar:/usr/lib/jvm/java-8-jdk/jre/lib/plugin.jar:/usr/lib/jvm/java-8-jdk/jre/lib/resources.jar:/usr/lib/jvm/java-8-jdk/jre/lib/rt.jar:/home/suzumiya/IdeaProjects/algorithm/out/production/algorithm:/home/suzumiya/.m2/repository/junit/junit/4.12/junit-4.12.jar:/home/suzumiya/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/opt/intellij-idea-ultimate-edition/lib/idea_rt.jar
         * user.name:suzumiya
         * java.vm.specification.version:1.8
         * sun.java.command:com.intellij.rt.execution.junit.JUnitStarter -ideVersion5 -junit4 com.itcast.collections.map.p216,testProperties
         * java.home:/usr/lib/jvm/java-8-jdk/jre
         * sun.arch.data.model:64
         * user.language:en
         * java.specification.vendor:Oracle Corporation
         * awt.toolkit:sun.awt.X11.XToolkit
         * java.vm.info:mixed mode
         * java.version:1.8.0_202
         * java.ext.dirs:/usr/lib/jvm/java-8-jdk/jre/lib/ext:/usr/java/packages/lib/ext
         * sun.boot.class.path:/usr/lib/jvm/java-8-jdk/jre/lib/resources.jar:/usr/lib/jvm/java-8-jdk/jre/lib/rt.jar:/usr/lib/jvm/java-8-jdk/jre/lib/sunrsasign.jar:/usr/lib/jvm/java-8-jdk/jre/lib/jsse.jar:/usr/lib/jvm/java-8-jdk/jre/lib/jce.jar:/usr/lib/jvm/java-8-jdk/jre/lib/charsets.jar:/usr/lib/jvm/java-8-jdk/jre/lib/jfr.jar:/usr/lib/jvm/java-8-jdk/jre/classes
         * java.vendor:Oracle Corporation
         * file.separator:/
         * java.vendor.url.bug:http://bugreport.sun.com/bugreport/
         * idea.test.cyclic.buffer.size:1048576
         * sun.io.unicode.encoding:UnicodeLittle
         * sun.cpu.endian:little
         * sun.cpu.isalist:
         */


    }
}
