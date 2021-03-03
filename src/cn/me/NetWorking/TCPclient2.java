package cn.me.NetWorking;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPclient2 {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8989);

        OutputStream os = socket.getOutputStream();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\code\\java\\practice\\src\\cn\\me\\NetWorking\\file\\image.png"));

        byte[] buffer = new byte[1024];
        for(int len = bis.read(buffer); len != -1; len = bis.read(buffer)) {
            os.write(buffer, 0, len);
        }

        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for(int len = is.read(buffer); len != -1; len = is.read(buffer)) {
            baos.write(buffer, 0, len);
        }
        System.out.println(baos);

        bis.close();
        os.close();
        socket.close();
        baos.close();
    }
}
