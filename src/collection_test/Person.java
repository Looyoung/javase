package collection_test;

import java.lang.reflect.Field;

public class Person implements Comparable {

    private String name;
    private int age;
    private String sex;

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public int compareTo(Object o) {
        Person other = (Person) o;
        return this.name.equals(other.name) ?
                (this.age == other.age ?
                        (this.sex.equals(other.sex) ? 0 : this.sex.compareTo(other.sex))
                        : this.age - other.age) :
                this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof Person) {
            try {
                Boolean check = true;
                Field[] objectFields = obj.getClass().getDeclaredFields();
                Field[] PersonFields = obj.getClass().getDeclaredFields();
                for (int i = 0; i < objectFields.length; i++) {
                    if (!objectFields[i].get(obj).equals(PersonFields[i].get(this))) {
                        check = false;
                        break;
                    }
                }
                return check;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        String person = this.name + this.age + this.sex;
        return person.hashCode();
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age +
                ", sex='" + sex + "'}";
    }
}
