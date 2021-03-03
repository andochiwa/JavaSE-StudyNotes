package cn.me.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IOWriterTest {
    public static void main(String[] args) {
        File file = new File("D:\\code\\java\\practice\\src\\cn\\me\\IO\\file\\hello1.txt");

        FileWriter fw = null;
        try {
            fw = new FileWriter(file, false);
            fw.write("i have a dream.");
            fw.write("you need to have a dream!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
