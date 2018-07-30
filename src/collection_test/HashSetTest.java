package collection_test;

import org.junit.Test;


import java.util.*;

/*
    HashSet --> 无序,允许null,不允许重复值,线程安全
    当向 HashSet 集合中存入一个元素时，HashSet 会调用该对象的 hashCode() 方法来得到该对象的 hashCode 值，
    然后根据 hashCode 值决定该对象在 HashSet 中的存储位置。
    HashSet 集合判断两个元素相等的标准：两个对象通过 hashCode() 方法比较相等，并且两个对象的 equals() 方法返回值也相等。

 */
public class HashSetTest {
    @Test
    public void test1() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("cbd");
        hashSet.add("abd");
        hashSet.add("klgas");
        hashSet.add("jagdl");
        hashSet.add("kk");
        hashSet.add("cbd");
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            String s = (String) iterator.next();
            System.out.println(s + " --hashcode--> " + s.hashCode());
            //kk --hashcode--> 3424
            //abd --hashcode--> 96355
            //cbd --hashcode--> 98277
            //jagdl --hashcode--> 100885144
            //klgas --hashcode--> 102136280
        }
        System.out.println(hashSet); //[kk, abd, cbd, jagdl, klgas]
    }

    @Test
    public void test2() {
        // LinkedHashSet插入性能略低于 HashSet，但在迭代访问 Set 里的全部元素时有很好的性能。
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("jaig");
        linkedHashSet.add("adg");
        linkedHashSet.add("zzz");
        linkedHashSet.add("sga");
        linkedHashSet.add("sga");
        System.out.println(linkedHashSet);  //[jaig, adg, zzz, sga]
    }

    @Test
    public void test3() {
        // TreeSet 是 SortedSet 接口的实现类，TreeSet 可以确保集合元素处于排序状态。
        // TreeSet 两种排序方法：自然排序(compareTo())
        // 和定制排序(Comparator接口)。默认情况下，TreeSet 采用自然排序。
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("ccc");
        treeSet.add("z");
        treeSet.add("aaaaa");
        treeSet.add("dd");
        treeSet.add("accd");
        System.out.println("treeSet 自然排序 ---> " + treeSet); //[aaaaa, accd, ccc, dd, z] 调用字符串的 compareTo 方法

        TreeSet<String> treeSet2 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length(); //根据字符串长度排序
            }
        });
        treeSet2.add("agagda");
        treeSet2.add("ccccccccc");
        treeSet2.add("zz");
        treeSet2.add("jjjj");
        treeSet2.add("kk");  // 由于返回0, 判断为与 zz 相等, 所以并没有放进set
        treeSet2.add("kkkkkkkkkkk");
        System.out.println("treeSet 定制排序 - 根据字符串长度 ---> " + treeSet2); //[zz, jjjj, agagda, ccccccccc, kkkkkkkkkkk]
    }
}

