package collection_test;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Louis");
        arrayList.add("089852");
        arrayList.add(null);
        arrayList.add("");
        System.out.println(arrayList);  //[Louis, 08985, null, ]  有序, 允许空值
        System.out.println(arrayList.toString());  //[Louis, 08985, null, ]
        System.out.println(arrayList.size());  //4
        arrayList.add("Louis");
        System.out.println(arrayList);  //[Louis, 08985, null, , Louis]  允许重复值

        arrayList.remove("Louis");
        System.out.println(arrayList); // [08985, null, , Louis]
        arrayList.remove(1);
        System.out.println(arrayList); // [08985, , Louis]
        arrayList.remove("0215");  // element not exist
        System.out.println(arrayList); // [08985, , Louis]

    }

    @Test
    public void methodsTest() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("aaa", 16, "m"));
        persons.add(new Person("ooo", 16, "f"));
        persons.add(new Person("zzc", 16, "m"));
        persons.add(new Person("fff", 16, "f"));
        persons.add(new Person("ooo", 22, "m"));
        Iterator<Person> iterator = persons.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-------------------------------------------------------------");
        // 相比iterator ==> listIterator 可以逆向遍历, 有nextIndex 和 previousIndex可以获取当前索引位置,
        // 有add()方法, 有set()方法
        ListIterator<Person> listIterator = persons.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next() + "---" + listIterator.nextIndex());
        }
        // 如果没有上门的操作 ,  下面的操作将不进入 while , 即 listIterator.hasPrevious() = false;
        System.out.println("//////////////////////////////////////");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previousIndex() + "---" + listIterator.previous());
        }

        Collections.sort(persons, (o1, o2) -> o1.compareTo(o2));
        System.out.println("sorted list --->" + persons);
        System.out.println("get(1) --->" + persons.get(1));
        System.out.println("indexOf(person) --->" + persons.indexOf(new Person("Cda", 19, "female")));
        persons.add(0, new Person("Joey", 22, "male"));
        System.out.println("add(index, person) --->" + persons);
        persons.set(0, new Person("Joey", 33, "male"));
        System.out.println("set(index, person) --->" + persons);
        System.out.println("subList(from, to)" + persons.subList(2, 4));  // 包含头, 不包含尾

        Object[] objects = persons.toArray();
        for (Object object : objects) {
            Person person = (Person) object;
            System.out.println(person);
        }
        System.out.println("----------------------");
        List<Object> personList = Arrays.asList(objects);  // Arrays.asList 返回的不是 ArrayList 也不是 Vector
        personList.forEach(person -> System.out.println(((Person) person).getName()));
    }

    @Test
    public void compareTest() {
        Person p1 = new Person("Louis", 16, "male");
        Person p2 = new Person("Louis", 16, "male");
        Person p3 = new Person("Louis", 18, "male");
        Person p4 = new Person("Louis", 16, "female");
        System.out.println(p1.equals(p2));  // true
        System.out.println(p1.compareTo(p2)); // 0
        System.out.println(p1.compareTo(p3));  // -2
        System.out.println(p1.compareTo(p4));  // 7
//        Set<Person> persons = new HashSet<>();
        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(new Person("Abc", 21, "male"));
        persons.add(new Person("Cda", 19, "female"));
        persons.add(new Person("Aac", 32, "male"));
        System.out.println(persons);
//        Collections.sort(persons, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.compareTo(o2);
//            }
//        });
        Collections.sort(persons, (o1, o2) -> o1.compareTo(o2));
        System.out.println("sorted list --->" + persons);

    }

    @Test
    public void trimToSizeTest() {
        List<String> stringList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            stringList.add("--->" + i * i);
        }
        stringList.add("----------aaaa");
        ((ArrayList<String>) stringList).trimToSize();  // 将 elementdata 中多余的部分去除
    }

    @Test
    public void predicateTest() {
        List<String> stringList = new ArrayList<>();
        stringList.addAll(Arrays.asList("12345", "5555621", "2646", "122", "5847856351", "12124"));
        System.out.println(filterString(stringList, isMoreThan(3)));
    }

    public static Predicate<String> isMoreThan(int i) {
        return p -> p.length() > i;
    }

    public static List<String> filterString(List<String> stringList, Predicate<String> predicate) {
        return stringList.stream().filter(predicate).collect(Collectors.toList());
    }
}
