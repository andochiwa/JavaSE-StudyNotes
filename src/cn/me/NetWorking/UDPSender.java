package cn.me.NetWorking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = "I'm a UDP";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, inet, 9090);

        socket.send(packet);

        socket.close();
    }
}
