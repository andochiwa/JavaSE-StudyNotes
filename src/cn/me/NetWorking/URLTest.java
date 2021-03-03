package cn.me.NetWorking;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = URLTest.class.getResource("file/image.png");

        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
        System.out.println(url.getFile());
        System.out.println(url.getQuery());
    }
}
