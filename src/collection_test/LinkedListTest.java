package collection_test;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

    @Test
    public void methodTest1() {
        List<String> personList = new LinkedList<>();
        personList.add("ccc");
        personList.add("cad");
        personList.add("ddd");
        personList.add("acd");
        personList.add("bgas");
        System.out.println(personList);
        ((LinkedList<String>) personList).addFirst("ggg");
        ((LinkedList<String>) personList).addLast("agb");
        System.out.println(personList);
        LinkedList<String> cloneList = (LinkedList<String>) ((LinkedList<String>) personList).clone();
        System.out.println(personList == cloneList); // false
        System.out.println(personList.equals(cloneList)); // true
        personList.clear();
        System.out.println("clear() --> " + personList); //[]
        System.out.println("1------------------------------------------------>>>");
        personList.add("ccc");
        personList.add("cad");
        personList.add("ddd");
        personList.add("acd");
        personList.add("bgas");
        Iterator<String> iterator = ((LinkedList<String>) personList).descendingIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ","); //bgas,acd,ddd,cad,ccc,
        }
        System.out.println();
        System.out.println("2------------------------------------------------>>>");
        int size = personList.size();
        for (int i = 0; i < size; i++) {
            // element(): Retrieves, but does not remove, the head (first element) of this list.
            // 与 peek() 一样
            System.out.print(((LinkedList<String>) personList).element() + ","); //ccc,cad,ddd,acd,bgas,
            ((LinkedList<String>) personList).removeFirst();
        }
        System.out.println("\r\n" + personList);  //[]
        System.out.println("3------------------------------------------------>>>");
        personList.add("ccc");
        personList.add("cad");
        personList.add("ddd");
        personList.add("acd");
        personList.add("bgas");
        while (!personList.isEmpty()) {
            // poll()
            // Retrieves and removes the head (first element) of this list.
            System.out.print(((LinkedList<String>) personList).poll() + ","); //ccc,cad,ddd,acd,bgas,
        }
        System.out.println("\r\n" + personList); //[]
        System.out.println("4------------------------------------------------>>>");
        personList.add("ccc");
        personList.add("cad");
        personList.add("ddd");
        personList.add("acd");
        personList.add("bgas");
        while (!personList.isEmpty()) {
            // pop()
            // Pops an element from the stack represented by this list.
            System.out.print(((LinkedList<String>) personList).pop() + ","); //ccc,cad,ddd,acd,bgas,
        }
        System.out.println("\r\n" + personList); //[]
        //	push(E e)
        //  Pushes an element onto the stack represented by this list.
        ((LinkedList<String>) personList).push("ddd");

        ((LinkedList<String>) personList).push("ccc");
        ((LinkedList<String>) personList).push("ggg");
        ((LinkedList<String>) personList).push(null);
        ((LinkedList<String>) personList).push("");
        System.out.println("\r\n" + personList); // [, null, ggg, ccc, ddd]

    }

}
