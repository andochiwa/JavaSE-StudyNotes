package cn.me.File;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest {

    public static void main(String[] args) throws IOException {
        File file1 = new File("java/practice/src/cn/me/File/Hello.txt");

        System.out.println(file1.getAbsolutePath()); //绝对路径
        System.out.println(file1.getPath()); //相对路径
        System.out.println(file1.getName()); //名字
        System.out.println(file1.getParent()); //所在路径
        System.out.println(file1.length()); //长度
        System.out.println(new Date(file1.lastModified())); //日期
        System.out.println();
        
        File file2 = new File("D:\\code\\java\\practice\\src\\cn\\me");
        var list = file2.list();
        for(var l : list) {
            System.out.println(l);
        }
        System.out.println();
        File[] files = file2.listFiles();
        for(var f : files) {
            System.out.println(f);
        }

        // 改名
        File file3 = new File(file1.getParent() + "/io.txt");
        boolean renameTo = file1.renameTo(file3);
        System.out.println(renameTo);
        System.out.println();

        // System.out.println(file2.isDirectory()); //判断是不是目录
        // System.out.println(file2.isFile()); //判断是不是文件
        // System.out.println(file3.exists()); //判断是否存在
        // System.out.println(file3.canRead()); //判断是否可读
        // System.out.println(file3.canWrite()); //判断是否可写
        // System.out.println(file3.isHidden()); //判断是否隐藏

        // 创建删除文件
        File file4 = new File(file3.getParent() + "/create.txt");
        if(!file4.exists()) {
            file4.createNewFile();
            System.out.println("create file success");
        } else {
            file4.delete();
            System.out.println("delete file success");
        }
        System.out.println();

        // 创建删除目录
        File file5 = new File(file3.getParent() + "\\io1\\io2");
        if(file5.mkdir()) {
            System.out.println("create dir success");
        } else {
            System.out.println("create dir fail");
        }

        File file6 = new File(file5.getPath());
        if(file6.mkdirs()) {
            System.out.println("create dir success");
        } else {
            System.out.println("create dir fail");
        }

    }
}
