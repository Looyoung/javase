package io_test;

import org.junit.Test;

import java.io.*;

public class ObjectStreamTest {

    // 对象的序列化过程：将内存中的对象通过ObjectOutputStream转换为二进制流，存储在硬盘文件中
    @Test
    public void testObjectOutputStream() {
        Person p1 = new Person("张三", "Male", 13, new Pet("Peggy"));
        Person p2 = new Person("李四", "Female", 12, new Pet("Tom"));
        try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream("src/io_test/person.txt"))) {
            objectOutputStream.writeObject(p1);
            objectOutputStream.flush();
            objectOutputStream.writeObject(p2);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 对象的反序列化过程：将硬盘中的文件通过ObjectInputStream转换为相应的对象
    @Test
    public void testObjectInputStream() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/io_test/person.txt"))) {
            Person p1 = (Person) objectInputStream.readObject();
            System.out.println(p1); // Person [name=null, sex=Male, age=null, pet=Pet-->Peggy<--(>^ω^<)]
            Person p2 = (Person) objectInputStream.readObject();
            System.out.println(p2); // Person [name=null, sex=Female, age=null, pet=Pet-->Tom<--(>^ω^<)]
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/*
 * 要实现序列化的类： 1.要求此类是可序列化的：实现Serializable接口
 * 2.要求类的属性同样的要实现Serializable接口
 * 3.提供一个版本号：private static final long serialVersionUID
 * 4.使用 static 或 transient 修饰的属性，不可实现序列化
 */
class Person implements Serializable {
    private static final long serialVersionUID = 23425124521L;
    static String name;
    private String sex;
    transient Integer age;
    Pet pet;

    public Person(String name, String sex, Integer age, Pet pet) {
        Person.name = name;
        this.sex = sex;
        this.age = age;
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", sex=" + sex + ", age=" + age + ", pet=" + pet + "]";
    }
}

class Pet implements Serializable {
    String name;

    public Pet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet-->" + this.name + "<--(>^ω^<)";
    }
}
