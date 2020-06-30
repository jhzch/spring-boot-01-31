package com.jh.springboot.threadJAVA_8.stream;

import com.jh.springboot.entity.User;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 一、Stream的三个操作步骤：
 *      1.创建Stream
 *      2.中间操作
 *      3.终止操作（终端操作）
 *
 * 集合、MYSQL本质就是存储东西的
 * 计算都应该交给流来操作！
 *
 * 题目要求：一分钟内完成此题，只能用一行代码实现
 * 现在有5个用户！筛选：
 * 1.ID必须是偶数
 * 2.年级必须大于23岁
 * 3.用户名转为大写字母
 * 4.用户名字母倒着排序
 * 5.只输出一个用户！
 */
public class StreamDemo {
    User user1 = new User(1,"a",21);
    User user2 = new User(2,"b",22);
    User user3 = new User(3,"c",23);
    User user4 = new User(4,"d",24);
    User user5 = new User(5,"e",25);
    List<User> list = Arrays.asList(user1,user2,user3,user4,user5);


    public void test2(){
        //1.通过Collection系列集合提供stream或parallelStream()
        List<String>  list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2.用过Arrays中的静态方法stream()获取数组流
        User[] user = new User[10];
        Stream<User> stream2 = Arrays.stream(user);

        //3.通过stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa","bb","cc");

        //4.创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0,(x)->x+2);
        stream4.limit(4).forEach(System.out::println);
        //生成
        Stream.generate(()->Math.random()).limit(5).forEach(System.out::println);

    }


    /**
     * 内部迭代：迭代操作由Stream API完成
     */
    public void test(){
        User user1 = new User(1,"a",21);
        User user2 = new User(2,"b",22);
        User user3 = new User(3,"c",23);
        User user4 = new User(4,"d",24);
        User user5 = new User(5,"e",25);
        List<User> list = Arrays.asList(user1,user2,user3,user4,user5);

        //计算交给Stream流
        //lambda表达式、链式编程、函数式接口、Stream流式计算
        list.stream()
                .filter(user -> {return user.getId()%2==0;}) //对条件进行过滤
                .filter(user -> {return user.getAge()>23;})
                .map(user -> {return user.getName().toUpperCase();})
                .sorted((uu1,uu2)->{return uu1.compareTo(uu2);})
                .forEach(System.out::println);
    }

    /**
     * 映射：
     *      map--接收lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数,该函数会被应用到每个元素上，并将其映射成一个新的元素
     *      flatMap--接收一个函数作为参数，将流中的每个值换成另一个流，然后把所有流连接成一个流
     */

    public void test3(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
        list.stream().map((str)->str.toUpperCase());

        List<User> list2 = new ArrayList<>();
        list2.stream().map(User::getName).forEach(System.out::println);

    }

    /**
     * 排序
     * sorted()自然排序
     * sorted(Comparator<T>) 自定义排序
     */
    public void test4(){
        List<String> list = Arrays.asList("ccc","aaa","bbb","ddd","eee");
        list.stream().sorted().forEach(System.out::println);

        List<User> list2 = new ArrayList<>();
        list2.stream().sorted((u1,u2)->{
            if(u1.getAge()==u2.getAge()){
                return u1.getName().compareTo(u2.getName());
            }else{
                return u1.getAge().compareTo(u2.getAge());
            }
        }).forEach(System.out::println);
    }

    /**
     * 查找与匹配
     * allMatch--检查是否匹配所有元素
     * anyMatch--检查是否至少匹配一个元素
     * noneMatch--检查是否没有匹配所有元素
     * findFirst--返回第一个元素
     * findAny--返回当前流中的任意元素
     * count--返回流中元素的总格式
     * max--返回流中最大值
     */
    public void test5(){
        boolean flag = list.stream().allMatch(u->u.getAge()>20);

        Optional<User> opt = list.stream().findFirst();
        opt.get();

    }

    /**
     * 规约
     * reduce（T identity,BinaryOperator）/reduce(BinaryOperator) --可以将流中元素反复结合起来，得到一个值
     */
    public void test6(){
        List<Integer> ll = Arrays.asList(1,2,3,4,5,6,7,8,9);
        //0为起始值得位置
        Integer sum =  ll.stream().reduce(0, (x,y)->x+y);
        System.out.println(sum);

        Optional<Integer> op = list.stream().map(User::getAge).reduce(Integer::sum);
        System.out.println(op.get());
    }

    /**
     * 收集
     */
    public void test7(){
        List<String> collect = list.stream().map(User::getName).collect(Collectors.toList());

        HashSet<String> set = list.stream().map(User::getName).collect(Collectors.toCollection(HashSet::new));
        
        //平均值
        Double age = list.stream().collect(Collectors.averagingInt(User::getAge));

        //总和

    }

    /*
	  	1.	给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
		，给定【1，2，3，4，5】， 应该返回【1，4，9，16，25】。
	 */
    public void test8(){
        Integer[] nums = new Integer[]{1,2,3,4,5,6};
    }

}
