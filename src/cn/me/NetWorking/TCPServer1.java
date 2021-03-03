package cn.me.NetWorking;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 异常不要throws,要用try...catch...finally
 */
public class TCPServer1 {
    public static void main(String[] args) throws IOException {
        server();
    }

    public static void server() throws IOException {
        ServerSocket ss = new ServerSocket(8899);

        Socket socket = ss.accept();
        
        InputStream is = socket.getInputStream();

        // 可能会乱码
        // byte[] buffer = new byte[20];
        // int len;
        // while((len = is.read(buffer)) != -1) {
        //     System.out.println(new String(buffer, 0, len));
        // }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[10];
        int len;
        while((len = is.read(buffer)) != -1) {
            baos.write(buffer, 0, len);
        }

        System.out.println(baos);

        System.out.println("收到了来自于" + socket.getInetAddress().getHostAddress());

        ss.close();
        socket.close();
        is.close();
        baos.close();
    }
}
