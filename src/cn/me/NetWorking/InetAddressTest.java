package cn.me.NetWorking;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.google.com");
            System.out.println(inet2);

            // InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            InetAddress inet3 = InetAddress.getLocalHost();
            System.out.println(inet3);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
