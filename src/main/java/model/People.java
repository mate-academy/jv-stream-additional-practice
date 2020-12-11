package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class People {

    private final String name;
    private final int age;
    private final Sex sex;
    private final List<Cat> catList;

    public People(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        catList = new ArrayList<>();
    }

    public People(String name, int age, Sex sex, List<Cat> catList) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.catList = catList;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public List<Cat> getCatList() {
        return catList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        People people = (People) o;
        return age == people.age
            && Objects.equals(name, people.name)
            && sex == people.sex
            && Objects.equals(catList, people.catList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex, catList);
    }

    @Override
    public String toString() {
        return "People{"
            + "name='" + name + '\''
            + ", age=" + age
            + ", sex=" + sex
            + ", catList=" + catList
            + '}';
    }

    public enum Sex {
        MAN, WOMEN
    }
}
