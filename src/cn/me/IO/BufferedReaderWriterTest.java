package cn.me.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterTest {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        File srcfile = new File("D:\\code\\java\\practice\\src\\cn\\me\\IO\\file\\hello.txt");
        File destfile = new File(srcfile.getParent(), "hello3.txt");

        BufferedReader br = null;
        BufferedWriter wr = null;
        try {
            br = new BufferedReader(new FileReader(srcfile));
            wr = new BufferedWriter(new FileWriter(destfile));

            char[] cbuf = new char[10];
            int len;
            while ((len = br.read(cbuf)) != -1) {
                wr.write(cbuf, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                wr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
