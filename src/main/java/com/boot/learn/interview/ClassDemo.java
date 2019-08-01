package com.boot.learn.interview;

public class ClassDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.boot.learn.interview.User");
        Class c2 = User.class;
        User u = new User();
        Class c3 = u.getClass();
    }
    static class User{

    }
}

class User{

}
