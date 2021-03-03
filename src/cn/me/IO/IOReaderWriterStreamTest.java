package cn.me.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流:字符流和字节流的转换
 * Exception要用try..catch..finally
 */
public class IOReaderWriterStreamTest {
    public static void main(String[] args) throws IOException {
        test1();
    }

    private static void test1() throws IOException {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        isr = new InputStreamReader(new FileInputStream(new File("D:\\code\\java\\practice\\src\\cn\\me\\IO\\file\\hello.txt")), "utf-8");
        osw = new OutputStreamWriter(new FileOutputStream(new File("D:\\code\\java\\practice\\src\\cn\\me\\IO\\file\\hello_gbk.txt")), "gbk");

        char[] cbuf = new char[10];
        for(int len = isr.read(cbuf); len != -1; len = isr.read(cbuf)) {
            osw.write(cbuf, 0, len);
        }

        isr.close();
        osw.close();
    }
}
