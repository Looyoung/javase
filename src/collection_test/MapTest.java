package collection_test;

import org.junit.Test;

import java.util.*;


/**
 * key不允许重复
 * HashMap
 * HashTable
 * Properties : 参考 jdbc 操作时从 jdbc.properties 文件读取数据库配置信息
 */
public class MapTest {

    /**
     * HashMap 判断两个 key 相等的标准是：两个 key 通过 equals() 方法返回 true，hashCode 值也相等。
     * HashMap 判断两个 value相等的标准是：两个 value 通过 equals() 方法返回 true。
     */
    @Test
    public void testHashMap() {
        HashMap<String, Person> hashMap = new HashMap<>();
        hashMap.put("a", new Person("a", 15, "m"));
        hashMap.put("c", new Person("c", 15, "m"));
        hashMap.put("g", new Person("d", 15, "m"));
        hashMap.put("b", new Person("b", 15, "m"));
        hashMap.put("e", new Person("e", 15, "m"));
        hashMap.put("d", new Person("d", 15, "m"));
        for (Map.Entry<String, Person> entrySet : hashMap.entrySet()) {
            System.out.println(entrySet.getKey() + "----" + entrySet.getValue());
            //a----Person{name='a', age=15, sex='m'}
            //b----Person{name='b', age=15, sex='m'}
            //c----Person{name='c', age=15, sex='m'}
            //d----Person{name='d', age=15, sex='m'}
            //e----Person{name='e', age=15, sex='m'}
            //g----Person{name='d', age=15, sex='m'}
        }
        for (String key : hashMap.keySet()) {
            System.out.println(key + "------>>>>>" + hashMap.get(key));
        }
    }

    /**
     * LinkedHashMap 可以维护 Map 的迭代顺序：迭代顺序与 Key-Value 对的插入顺序一致
     */
    @Test
    public void linkedHashMapTest() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("abc", "ccc");
        linkedHashMap.put("dfc", "cadfc");
        linkedHashMap.put("csdg", "ccfafc");
        linkedHashMap.put("a", "ccc");
        linkedHashMap.put("agaga", "ccffc");
        for (Map.Entry<String, String> map : linkedHashMap.entrySet()) {
            System.out.println("key:" + map.getKey() + ">>>value:" + map.getValue());
            //key:abc>>>value:ccc
            //key:dfc>>>value:cadfc
            //key:csdg>>>value:ccfafc
            //key:a>>>value:ccc
            //key:agaga>>>value:ccffc

        }
    }

    /**
     * TreeMap存储 Key-Value 对时，需要根据 key-value 对进行排序。TreeMap 可以保证所有的 Key-Value 对处于有序状态.
     * 与 TreeSet 类似, TreeMap 的key排序也分为 自然排序和定制排序
     * 自然排序: TreeSet 的所有的 key 必须实现 Comparable 接口
     * 定制排序: 创建 TreeSet 时, 传入一个 Comparator 对象
     */
    @Test
    public void treeMapTest() {
        TreeMap<Person, String> treeMap = new TreeMap<>();
        treeMap.put(new Person("cde", 15, "male"), "175");
        treeMap.put(new Person("gdsa", 15, "male"), "169");
        treeMap.put(new Person("dfg", 15, "male"), "182");
        treeMap.put(new Person("acgasg", 15, "male"), "156");
        treeMap.put(new Person("oa", 15, "male"), "174");
        treeMap.put(new Person("dfg", 8, "male"), "175");
        for (Map.Entry<Person, String> entry : treeMap.entrySet()) {
            System.out.println("key:" + entry.getKey() + ">>>value:" + entry.getValue());
            //key:Person{name='acgasg', age=15, sex='male'}>>>value:156
            //key:Person{name='cde', age=15, sex='male'}>>>value:175
            //key:Person{name='dfg', age=8, sex='male'}>>>value:175
            //key:Person{name='dfg', age=15, sex='male'}>>>value:182
            //key:Person{name='gdsa', age=15, sex='male'}>>>value:169
            //key:Person{name='oa', age=15, sex='male'}>>>value:174
        }
        System.out.println("<-<-<-<-<-<-<-<-<-<-<-<-<-<-<->->->->->->->->->->->->->->->");
        // 创建 key 根据字符串长度
        TreeMap<String, String> treeMap1 = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length() == 0 ? o1.compareTo(o2) : o1.length() - o2.length();
            }
        });
        treeMap1.put("casg", "aga");
        treeMap1.put("aaacasg", "aga");
        treeMap1.put("zzcasg", "aga");
        treeMap1.put("fcasg", "aga");
        treeMap1.put("zzf", "aga");
        treeMap1.put("kfg", "aga");
        for (Map.Entry<String, String> entry : treeMap1.entrySet()) {
            System.out.println("key:" + entry.getKey() + ">>>value:" + entry.getValue());
            //key:kfg>>>value:aga
            //key:zzf>>>value:aga
            //key:casg>>>value:aga
            //key:fcasg>>>value:aga
            //key:zzcasg>>>value:aga
            //key:aaacasg>>>value:aga
        }
    }

    @Test
    public void testFor() {
        String[] strings = new String[5];
        for (String str : strings) {
            str = "Louis";
            System.out.println(str);
        }
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + ","); //null,null,null,null,null,
        }
    }
}
