package com.jh.springboot.threadJAVA_8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * 函数式接口：只有一个抽象方法的接口，@FunctionalInterface注解声明为函数式接口，可以使用lambda表达式，简化接口的实现
 * lambda表达式：允许把函数作为一个方法的参数（函数作为参数传递进方法中） 使用 Lambda 表达式可以使代码变的更加简洁紧凑。
 */
public class LambdaDemo {
    /**
     * Function函数型接口,有一个输入参数，有一个输出
     * 只要是函数型接口 可以用lambda表达式简化
     */
    public void function(){
//        Function<Object,String> function = new Function<Object, String>() {
//            @Override
//            public String apply(Object str) {
//                return (String) str;
//            }
//        };
        Function<String,String> function = (str)->{return str;};
        System.out.println(function.apply("jh"));

        String newStr = strHandler("\t\t\tjh加油啊 ",(str)->str.trim());
        String subStr = strHandler("jh加油啊",(str)->str.substring(2,5));
    }

    public String strHandler(String str,Function<String,String> fun){
          return fun.apply(str);
    }

    /**
     * 段定型函数式接口：有一个输入参数，返回值只能是 布尔值！
     */
    public void predicate(){
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String str) {
//                return str.isEmpty();
//            }
//        };
        Predicate<String> predicate = (str)->{return str.isEmpty();};
        System.out.println(predicate.test(""));
        List<String> list = Arrays.asList("hello","jh","fighting");
        List<String> strList = filterStr(list,(s)->s.length()>3);
        strList.forEach(str-> System.out.println(str));
    }

    public List<String> filterStr(List<String> list,Predicate<String> pre){
        List<String> ll = new ArrayList<>();
        ll.forEach(str-> {
            if(pre.test(str)){
                ll.add(str);
            }
        });
        return ll;
    }

    /**
     * 消费型接口：只有输入，没有返回值
     */
    public void consumer(){
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String o) {
                System.out.println(o);
            }
        };
        Consumer<String> con = (str) -> {
            System.out.println(str);
        };
        happy(1000,m-> System.out.println("消费"+m+"元"));
    }

    public void happy(double money,Consumer<Double> con){
        con.accept(money);
    }

    /**
     * 提供型接口：没有方法，只有返回值
     */
    public void supplier(){
//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "jh";
//            }
//        };
        Supplier<String> supplier = () -> {return "jh";};
        System.out.println(supplier.get());

       List<Integer> list = getNumList(5,()->(int)(Math.random()*100));
       list.forEach(num-> System.out.println(num));
    }

    public List<Integer> getNumList(int num,Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<num;i++){
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }

}
