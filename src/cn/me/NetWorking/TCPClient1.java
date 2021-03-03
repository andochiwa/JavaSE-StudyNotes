package cn.me.NetWorking;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient1 {
    public static void main(String[] args) throws IOException {
        client();
    }

    public static void client() throws IOException {
        InetAddress inet = InetAddress.getLocalHost();
        
        Socket socket = new Socket(inet, 8899);

        OutputStream os = socket.getOutputStream();
        os.write("hello, i'm app".getBytes());

        socket.close();
    }
}
