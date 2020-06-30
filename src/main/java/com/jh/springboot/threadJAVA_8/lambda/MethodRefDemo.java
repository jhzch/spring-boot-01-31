package com.jh.springboot.threadJAVA_8.lambda;

import com.jh.springboot.entity.User;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”（可以理解为方法引用是Lambda表达式的另外一种表现形式）
 * 主要有三种语法格式：
 * 对象：：实例方法名
 * 类：：静态方法名
 * 类：：实例方法名
 * 注意：
 *  lambda 体重调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致！
 *
 *  二、构造器引用
 *
 *  ClassName::new
 *
 *  注意：需要调用的构造器参数列表要和函数式接口中抽象方法的参数列表保持一致
 *
 *  三、数组引用
 *
 *  Type:new;
 */
public class MethodRefDemo {

    //构造器引用  构造器参数列表和函数式接口的参数列表值一样
    public void test5(){
        Supplier<User> sup = ()->new User();

        //构造器引用
        Supplier<User> sup2 = User::new;
    }

    //数组引用
    public void test6(){
        Function<Integer,String[]> fun = (x)->new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);

        Function<Integer,String[]> fun2 = String[]::new;
        String[] strs2 = fun2.apply(89);
        System.out.println(strs2.length);
    }


    //对象：：实例方法名
    public void test(){
        Consumer<String> con = (str)-> System.out.println(str);

        Consumer<String> con2 = System.out::println;
        con2.accept("abcdef");
    }

    public void test2(){
        User user = new User();
        Supplier<String> sup = ()->user.getName();
        String str = sup.get();
        System.out.println(str);

        Supplier<String> sup2 = user::getName;
        System.out.println(sup2.get());

    }

    //类：：静态方法名
    public void test3(){

        Comparator<Integer> con = (x, y)-> Integer.compare(x,y);

        Comparator<Integer> conn2 = Integer::compare;

        conn2.compare(4,8);

    }

    //类：：实例方法名
    public void test4(){
        BiPredicate<String,String> bp = (x,y)->x.equals(y);

        BiPredicate<String,String>bp2 = String::equals;
    }
}
