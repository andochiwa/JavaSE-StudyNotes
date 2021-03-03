package cn.me.IO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class IOReaderTest {
    public static void main(String[] args) {
        FileReader fr = null;
        File file = new File(IOReaderTest.class.getResource("file/hello.txt").getPath());
        try {
            fr = new FileReader(file);
            int data = fr.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr != null) 
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println();

        File file2 = new File(file.getPath());
        FileReader fr2 = null;
        try {
            fr2 = new FileReader(file2);

            char[] cbuf = new char[5];
            int len;
            while ((len = fr2.read(cbuf)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(fr2 != null) {
                try {
                    fr2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
}
