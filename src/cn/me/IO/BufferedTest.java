package cn.me.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedTest {
    public static void main(String[] args) {
        bufferStreamTest();
    }

    private static void bufferStreamTest() {
        File srcfile = new File("D:\\code\\java\\practice\\src\\cn\\me\\IO\\file\\test.mp4");
        File destfile = new File(srcfile.getParent(), "test2.mp4");
        // FileInputStream fis = null;
        // FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            FileInputStream fis = new FileInputStream(srcfile);
            FileOutputStream fos = new FileOutputStream(destfile);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
               bos.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            // fos.close();
            // fis.close();
        }

    }
}
