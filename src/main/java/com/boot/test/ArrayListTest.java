package com.boot.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhang.wenhan
 * @description ArrayListTest
 * @date 2019/4/18 13:57
 */
public class ArrayListTest {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user0 = new User();
        user0.setAge(0);
        user0.setName("张三");
        list.add(user0);
        User user01 = new User();
        user01.setAge(0);
        user01.setName("张三");
        list.add(user01);
        User user = new User();
        user.setAge(1);
        user.setName("张三");
        list.add(user);
        User user2 = new User();
        user2.setAge(2);
        user2.setName("李四");
        list.add(user2);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            System.out.println("当前年龄" + u.getAge());
            if (u.getAge() == 0) {
                list.remove(u);
            }
        }
        System.out.println(list.size());

        User[] users1 = new User[2];
        users1[0] = user;
        users1[1] = user2;

        User[] users = Arrays.copyOf(users1, 2);
        System.out.println(users[0] == users1[0]);


    }

}

class User {
    String name;
    int age;

    public User() {
        super();
    }
    public User(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}