package io_test;

import org.junit.Test;

import java.io.*;

/**
 * 转换流提供了在字节流和字符流之间的转换
 * Java API提供了两个转换流：
 * InputStreamReader和OutputStreamWriter
 * 字节流中的数据都是字符时，转成字符流操作更高效。
 */
public class InputStreamReaderTest {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("src/io_test/test_1.txt"), true)));
        String readLine = null;
        while ((readLine = bufferedReader.readLine()) != null) {
            if ("over".equals(readLine))
                break;
            bufferedWriter.write(readLine.toUpperCase());
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
    }

    /**
     *  注意!!!!! 在 Test 模式下, System.in 无法获取控制台输入哦
     */
//    @Test
//    public void test1() throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test_1.txt")));
//        String readLine = null;
//        while ((readLine = bufferedReader.readLine()) != null) {
//            if ("over".equals(readLine))
//                break;
//            bufferedWriter.write(readLine.toUpperCase());
//            bufferedWriter.newLine();
//            bufferedWriter.flush();
//        }
//    }
}

