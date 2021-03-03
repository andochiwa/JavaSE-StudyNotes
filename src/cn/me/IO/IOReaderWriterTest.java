package cn.me.IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOReaderWriterTest {

    public static void main(String[] args) {
        File srcfile = new File("D:\\code\\java\\practice\\src\\cn\\me\\IO\\file\\hello.txt");
        File destfile = new File(srcfile.getParent(), "hello2.txt");

        FileWriter fw = null;
        FileReader fr = null;

        try {
            fr = new FileReader(srcfile);
            fw = new FileWriter(destfile);

            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
