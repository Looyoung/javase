package io_test;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterTest {

    @Test
    public void testFileReaderWriter() {
        File src = new File("src/io_test/test_copy.txt");
        File dest = new File("src/io_test/test_writer.txt");
        try (FileReader fileReader = new FileReader(src);
             FileWriter fileWriter = new FileWriter(dest)) {
            char[] chars = new char[32];
            int len = 0;
            while ((len = fileReader.read(chars)) != -1) {
                fileWriter.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFileReader() {
        File file = new File("src/io_test/test_copy.txt");
        try (FileReader fileReader = new FileReader(file)) {
            char[] chars = new char[32];
            int len = 0;
            while ((len = fileReader.read(chars)) != -1) {
                String str = new String(chars, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
