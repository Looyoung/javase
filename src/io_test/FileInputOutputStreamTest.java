package io_test;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamTest {

    @Test
    public void testProperties() {
        System.getProperties().list(System.out);
    }

    @Test
    public void testCopyFile() {
        long start = System.currentTimeMillis();
//		String src = "C:\\Users\\shkstart\\Desktop\\1.avi";
//		String dest = "C:\\Users\\shkstart\\Desktop\\2.avi";
        String src = "src/io_test/test.txt";
        String dest = "src/io_test/test_copy.txt";
        copyFile(src, dest);
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start) + "毫秒"); //4
    }

    // 实现文件复制的方法
    public void copyFile(String src, String dest) {
        // 1.提供读入、写出的文件
        File file1 = new File(src);
        File file2 = new File(dest);
        // 2.提供相应的流 使用 TWR 语法
        try (FileInputStream fis = new FileInputStream(file1);
             FileOutputStream fos = new FileOutputStream(file2)) {
            // 3.实现文件的复制
            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1) {
                // fos.write(b);//错误的写法两种： fos.write(b,0,b.length);
                fos.write(b, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 从硬盘读取一个文件，并写入到另一个位置。（相当于文件的复制）
    @Test
    public void testFileInputOutputStream() {
        // 1.提供读入、写出的文件
        File src = new File("D:\\学习文档\\Java\\eclipse.jpg");
        File dest = new File("D:\\学习文档\\Java\\eclipse2.jpg");
        // 2.提供相应的流
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            // 3.实现文件的复制
            byte[] b = new byte[20];
            int len;
            while ((len = fis.read(b)) != -1) {
                // fos.write(b);  // 错误
                // fos.write(b,0,b.length);
                fos.write(b, 0, len); // 错误
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * FileOutputStream 常用方法如下
     * 1、FileOutputStream(String name)
     * 2、FileOutputStream(File file)
     * 3、FileOutputStream(File file, boolean append)
     */
    @Test
    public void testFileOutputStream() {
        try (FileOutputStream fileOutputStream =
                     new FileOutputStream("d:/学习文档/Java/test.txt", true)) {
            fileOutputStream.write("哈哈哈 测试 FileOutputStream !!??\r\n 什么鬼???".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFileInputStream1() {
        // 2.创建一个FileInputStream类的对象
        FileInputStream fis = null;
        try {
            // 1.创建一个File类的对象。
            File file = new File("d:/学习文档/Java/test.txt");
            fis = new FileInputStream(file);
            // 3.调用FileInputStream的方法，实现file文件的读取。
            int b;
            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭相应的流
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileInputStream() {
        FileInputStream fileInputStream = null;
        try {
            File file = new File("d:/学习文档/Java/test.txt");
            fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            int i = 0;
            i = fileInputStream.read(bytes);  // read(byte[]) 读取buffer.length个字节
            System.out.println(i);
            System.out.println(new String(bytes, 0, i));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
