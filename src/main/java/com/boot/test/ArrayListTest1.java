package com.boot.test;

import java.util.*;

/**
 * @author zhang.wenhan
 * @description ArrayListTest1
 * @date 2019/7/4 10:22
 */
public class ArrayListTest1 {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user0 = new User("张三", 11);
        User user1 = new User("李四", 12);
        User user2 = new User("王五", 13);
        User user3 = new User("赵四", 14);
        User user4 = new User("杨六", 15);
        list.add(user0);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        List<User> subList = list.subList(1,3);
        for(User user : subList){
            if(Objects.equals("李四", user.getName())){
                user.setAge(28);
            }
        }

        for(User user  : subList){
            System.out.println(user.toString());
        }

        for(User user  : list){
            System.out.println(user.toString());
        }

        List<String> emptyList =  Collections.emptyList();
        // empty list (immutable). 不可对其进行添加或者删除元素的操作。 UnsupportedOperationException 异常
        // emptyList.add("a");

        String[] str = new String[] { "yang", "hao" };
        List<String> strList = Arrays.asList(str);
        str[0] = "111";
//        strList.add("1234"); list.add("yangguanbao"); 运行时异常。 UnsupportedOperationException
        for (String s : strList){
            System.out.println(s);
        }

        List<String> removeList = new ArrayList<>();
        removeList.add("1");
        removeList.add("2");
//        removeList.add("3");
        // 集合循环删除时，不能使用foreach 会抛出 ConcurrentModificationException
//        for(String remove : removeList){
//            if("2".equals(remove)){
//                removeList.remove(remove);
//            }
//        }
//        // 应该使用 iterator
        Iterator<String> iterator = removeList.iterator();
        String item;
        while (iterator.hasNext()){
            item= iterator.next();
            if("1".equals(item)){
                iterator.remove();
            }
        }
        for(String remove : removeList){
            System.out.println(remove);
        }
    }

}
