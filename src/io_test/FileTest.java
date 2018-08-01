package io_test;

import org.junit.Test;

import java.io.File;

/**
 * File类是IO包中唯一代表磁盘文件本身的对象，File类定义了一些与平台无关的方法来操作文件。
 * 通过调用File类提供的各种方法，能够完成创建、删除文件、重命名文件、判断文件的读写权限权限
 * 是否存在、设置和查询文件的最近修改时间等操作。
 * <p>
 * File类没有无参构造方法，最常用的是使用下面的构造方法来生成File对象（注意分隔符可以使用"/"和"\"，但是使用"\"必须写"\\"，
 * File(String pathName)
 */
public class FileTest {

    private static final String FILE_SEPARATOR = File.separator;

    @Test
    public void testFile() {

        String fileName = "d:" + FILE_SEPARATOR + "学习文档" + FILE_SEPARATOR + "Java";
        File file = new File(fileName);
        if (file.exists() && file.isDirectory()) {
            System.out.println("file是一个文件夹!");
            File[] files = file.listFiles(); // 获取目录下的所有文件/文件夹(仅该层路径下)
            System.out.println("d:" + FILE_SEPARATOR + "学习文档" + FILE_SEPARATOR + "Java 路径下有文件:");
            for (File f : files) {
                // File.toString(){return file.getPath()}
                System.out.println(f);
            }
            System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
            System.out.println("files[0]的文件名：" + files[0].getName()); // 获取文件名、文件夹名
            System.out.println("files[0]的文件路径：" + files[0].getPath()); // 获取文件、文件夹路径
            System.out.println("files[0]的绝对路径：" + files[0].getAbsolutePath()); // 获取文件、文件夹绝对路径
            System.out.println("files[0]的父文件夹名：" + files[0].getParent()); // 获取文件父目录路径
            System.out.println(files[0].exists() ? "files[0]的存在" : "files[0]的不存在"); // 判断文件、文件夹是否存在
            System.out.println(files[0].canWrite() ? "files[0]的可写" : "files[0]的不可写"); // 判断文件是否可写
            System.out.println(files[0].canRead() ? "files[0]的可读" : "files[0]的不可读"); // 判断文件是否可读
            System.out.println(files[0].canExecute() ? "file[0]可执行" : "file[0]不可执行"); // 判断文件是否可执行
            System.out.println(files[0].isDirectory() ? "files[0]的是目录" : "files[0]的不是目录"); // 判断文件、文件夹是不是目录
            System.out.println(files[0].isFile() ? "files[0]的是文件" : "files[0]的不是文件"); // 判断拿文件、文件夹是不是标准文件
            System.out.println(files[0].isAbsolute() ? "files[0]的路径名是绝对路径" : "files[0]的路径名不是绝对路径"); // 判断路径名是不是绝对路径
            System.out.println("files[0]的最后修改时间：" + files[0].lastModified()); // 获取文件、文件夹上一次修改时间
            System.out.println("files[0]的大小：" + files[0].length() + " Bytes"); // 获取文件的字节数，如果是一个文件夹则这个值为0
            System.out.println("files[0]的路径转换为URI：" + files[0].toURI()); // 获取文件路径URI后的路径名


            //删除的如果是一个文件夹的话，文件夹下还有文件/文件夹，是无法删除成功的
            if (files[0].exists())
                files[0].delete(); // 删除指定的文件、文件夹
            if (files[1].exists())
                files[1].deleteOnExit(); // 当虚拟机终止时删除指定的文件、文件夹
        }
    }
}
