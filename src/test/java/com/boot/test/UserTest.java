package com.boot.test;

/**
 * @author zhang.wenhan
 * @description UserTest
 * @date 2019/8/16 11:38
 */
public class UserTest {

    public static void main(String[] args) {
        User user = new User("张三", "18");
        change(user);
        System.out.println(user);
    }

    public static void change(User user) {
        user = new User("李四", "20");
    }

}

class User {
    private String name;
    private String age;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}


