package cn.me.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@SuppressWarnings("unused")
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInput();
        // ImageInput();
        copyFile("D:\\code\\java\\practice\\src\\cn\\me\\IO\\file\\image.png", "D:\\code\\java\\practice\\src\\cn\\me\\IO\\file\\image2.png");

    }
    private static void FileInput() {
        File file = new File("D:\\code\\java\\practice\\src\\cn\\me\\IO\\file\\hello.txt");
        
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
    }

    private static void copyFile(String srcpath, String destpath) {
        File srcFile = new File(srcpath);
        File destFile = new File(destpath);
    
        FileInputStream fis;
        FileOutputStream fos;
        fis = null;
        fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
    
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }

    }

    private static void ImageInput() {
        File srcFile = new File("D:\\code\\java\\practice\\src\\cn\\me\\IO\\file\\image.png");
        File destFile = new File(srcFile.getParent(), "image2.png");
    
        FileInputStream fis;
        FileOutputStream fos;
        fis = null;
        fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
    
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
    }
}
