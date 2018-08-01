package io_test;

import org.junit.Test;

import java.io.*;

/**
 * 为了提高数据读写的速度，Java API提供了带缓冲功能的流类，在使用这些流类时，会创建一个内部缓冲区数组
 * 根据数据操作单位可以把缓冲流分为
 * BufferedInputStream 和 BufferedOutputStream
 * BufferedReader 和 BufferedWriter
 * 缓冲流要“套接”在相应的节点流之上，对读写的数据提供了缓冲的功能，提高了读写的效率，同时增加了一些新的方法
 * 对于输出的缓冲流，写出的数据会先在内存中缓存，使用 flush() 将会使内存中的数据立刻写出
 */
public class BufferedTest {

    @Test
    public void testBufferedReader() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/io_test/test.txt")));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("src/io_test/test_buffered_3.txt")))) {
            /*char[] chars = new char[32];
            int len;
            while ((len = bufferedReader.read(chars))!=-1){
                bufferedWriter.write(chars,0,len);
                bufferedWriter.flush();
            }*/
            String tempString;
            while ((tempString = bufferedReader.readLine()) != null) {
                bufferedWriter.write(tempString + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBufferedInputStream() {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("src/io_test/test.txt")));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("src/io_test/test_buffered_1.txt")))) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                // write只是将数据输出到缓冲区，还没有输出到目的地。
                bufferedOutputStream.write(bytes, 0, len);
                // flush是清空缓冲区，就是说立即输出到输出目的地，而不是等缓冲区满了再输出，
//                bufferedOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
