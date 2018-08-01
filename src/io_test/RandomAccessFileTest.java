package io_test;

import org.junit.Test;


import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile类为用户提供了两种构造方法：
 * 1、RandomAccessFile(File file, String mode)
 * 2、RandomAccessFile(String name, String mode)
 * mode --> r, rw, rws, rwd
 */
public class RandomAccessFileTest {
    @Test
    public void testRandomAccessFile() {
        // 使用 java7 新增的 TWR (try with resource), 简化资源关闭
        try (RandomAccessFile randomAccessFile =
                     new RandomAccessFile("d:/学习文档/Java/test.txt", "rw")) {
            randomAccessFile.seek(21);
            System.out.println(randomAccessFile.getFilePointer());
            byte[] bytes = new byte[1024];
            String line = null;
            while ((line = randomAccessFile.readLine()) != null) {
                // RandomAccessFile 读写文件时，不管文件中保存的数据编码格式是什么,
                // 使用 RandomAccessFile对象方法的 readLine() 都会将编码格式转换成 ISO-8859-1,
                // 所以输出显示时还要在进行一次转码
                System.out.println(new String(line.getBytes("ISO-8859-1"), "utf-8"));
            }
            System.out.println(randomAccessFile.getFilePointer()); //798
            randomAccessFile.write("\r\nHello Louis!!!!!哈哈哈我是中文测试".getBytes());  // ok
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            randomAccessFile.close();
        }
    }
}
