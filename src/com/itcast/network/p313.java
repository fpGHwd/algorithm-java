package com.itcast.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

class URLDemo {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://45.78.52.19:8080/docs/introduction.html");
        System.out.println("getProtocol() : " + url.getProtocol());
        System.out.println("getHost() : " + url.getHost());
        System.out.println("getPath() : " + url.getPath());
        System.out.println("getPort() : " + url.getPort());
        System.out.println("getFile() : " + url.getFile());
        System.out.println("getQuery() : " + url.getQuery());


        /**
         * getProtocol() : http
         * getHost() : 45.78.52.19
         * getPath() : /docs/introduction.html
         * getPort() : 8080
         * getFile() : /docs/introduction.html
         * getQuery() : null
         *
         *
         * URL url = new URL("http://45.78.52.19:8080/docs/introduction.html?name=haha&aeg=30");
         * getProtocol() : http
         * getHost() : 45.78.52.19
         * getPath() : /docs/introduction.html
         * getPort() : 8080
         * getFile() : /docs/introduction.html?name=haha&aeg=30
         * getQuery() : name=haha&aeg=30
         *
         *
         * URL url = new URL("http://45.78.52.19/docs/introduction.html");
         * getProtocol() : http
         * getHost() : 45.78.52.19
         * getPath() : /docs/introduction.html
         * getPort() : -1
         * getFile() : /docs/introduction.html
         * getQuery() : null
         *
         * 端口-1时指定80端口
         */

        /**
         * getQuery()比较重要
         */

    }

}

class URLConnectionDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://45.78.52.19:8080/docs/introduction.html");
        URLConnection urlc = url.openConnection(); // public abstract class URLConnection
        System.out.println(urlc); //  sun.net.www.protocol.http.HttpURLConnection:http://45.78.52.19:8080/docs/introduction.

        InputStream is = urlc.getInputStream();

        byte[] buf = new byte[1024];

        int len = is.read(buf);
        System.out.println(new String(buf));
        /**
         * <!DOCTYPE html SYSTEM "about:legacy-compat">
         * <html lang="en"><head><META http-equiv="Content-Type" content="text/html; charset=UTF-8"><link href="./images/docs-stylesheet.css" rel="stylesheet" type="text/css"><title>Apache Tomcat 9 (9.0.17) - Introduction</title><meta name="author" content="Robert Slifka"><script type="application/javascript" data-comments-identifier="tomcat-9.0-doc/introduction">
         *     "use strict"; // Enable strict mode
         *
         *     (function() {
         *       var thisScript = document.currentScript;
         *       if (!thisScript) { // Workaround for IE <= 11
         *         var scripts = document.getElementsByTagName("script");
         *         thisScript = scripts[scripts.length - 1];
         *       }
         *       document.addEventListener("DOMContentLoaded", (function() {
         *         var commentsDiv = document.getElementById("comments_thread");
         *         var commentsShortname = "tomcat";
         *         var commentsIdentifier = "https://tomcat.apache.org/" +
         *           thisScript.getAttribute("data-comments-identifier") + ".html";
         *
         *         (function(w, d) {
         */

        /**
         * 不用在里面GUI框里面切分字符串
         */


        Object obj = urlc.getContent();
        System.out.println(obj); // sun.net.www.protocol.http.HttpURLConnection$HttpInputStream@506e1b77
    }
}

public class p313 {
}
