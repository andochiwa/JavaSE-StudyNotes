package cn.me.NetWorking;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8989);

        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\code\\java\\practice\\src\\cn\\me\\NetWorking\\file\\image2.png"));

        byte[] buffer = new byte[1024];
        for(int len = is.read(buffer); len != -1; len = is.read(buffer)) {
            bos.write(buffer, 0, len);
        }

        OutputStream os = socket.getOutputStream();
        os.write("accept image, thank".getBytes());

        ss.close();
        socket.close();
        is.close();
        bos.close();
        os.close();
    }
}

