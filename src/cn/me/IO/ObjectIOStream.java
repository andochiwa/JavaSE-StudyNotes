package cn.me.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIOStream {
    public static void main(String[] args) {
        outputTest();
        inputTest();

    }

    public static void outputTest() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new FileOutputStream("D:\\code\\java\\practice\\src\\cn\\me\\IO\\file\\object.dat"));
            oos.writeObject(new String("i love peki"));
            oos.flush();

            oos.writeObject(new Person("Tom", 23));
            oos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void inputTest() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new FileInputStream("D:\\code\\java\\practice\\src\\cn\\me\\IO\\file\\object.dat"));
            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str);

            var p = (Person) ois.readObject();
            System.out.println(p);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
            }
        }

    }
}
