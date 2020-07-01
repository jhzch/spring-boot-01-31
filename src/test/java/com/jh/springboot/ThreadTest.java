package com.jh.springboot;

import com.alibaba.fastjson.JSONObject;
import com.jh.springboot.entity.Book;
import com.jh.springboot.entity.TestDto;
import com.jh.springboot.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@SpringBootTest
public class ThreadTest {


   public void test1(){
       ExecutorService threadPool = Executors.newSingleThreadExecutor();
       ExecutorService threadPool2 =  Executors.newCachedThreadPool();
       ExecutorService threadPool3 = Executors.newFixedThreadPool(5);
       for(int i=0;i<10;i++) {
           threadPool.execute(() -> {
               System.out.println(Thread.currentThread().getName()+"  ok");
           });
       }
   }

   public void test2(){
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                 TimeUnit.SECONDS,
                 new LinkedBlockingDeque<>(3),
                 Executors.defaultThreadFactory(),
                 new ThreadPoolExecutor.AbortPolicy());//银行满了，还有人进来，不处理这个人的，抛出异常
   }


    public static void main(String[] args) {
//       String fields = "id,name,status,createDate,chargeDirection,chargeMethod+$chargeType@id,name";
//        String[] split = fields.split("\\+");
//        String prefix = "chargeType";
//        List<String> collect = Arrays.asList(split).stream().filter(s -> StringUtils.startsWith(s, prefix) && StringUtils.countMatches(s, "@") > 1).collect(Collectors.toList());
//        System.out.println(collect.size());
//        String str = "*+chargeResult@id,money,settlementDate+chargeResult@chargeName@id, name+chargeResult@chargeType@id, name";
//        List<String> routes = Arrays.asList(str.split("\\+"));
//        List<String> collect = routes.stream().filter(f -> StringUtils.countMatches(f, '@') > 0 && StringUtils.countMatches(f, '$') == 0).collect(Collectors.toList());
//        for (int i=0;i<collect.size();i++){
//            System.out.println(collect.get(i));
//        }
//       String[] sub = StringUtils.split("chargeResult@chargeName@id, name","@",2);
//       for(int j=0;j<sub.length;j++){
//           System.err.println(sub[j]);
//       }
        Map<String, List<String>> sl = new HashMap<>();
        List<String> fs = new ArrayList<>();
        fs.add("id,money,settlementDate");
        sl.put("chargeResult",fs);
        String t = StringUtils.join(sl.get("chargeResult"), '+');
        System.out.println(t);

   }


    @Test
    public void test43(){
       String str = "id,name,status,code+dictArea@id,name+dictArea@dictStore@id,name+dictArea@dictStore@storageCenter@id,name";
        List<String> routes = Arrays.asList(str.split("\\+"));
        List<String> collect = routes.stream().filter(f -> StringUtils.countMatches(f, '@') > 0 && StringUtils.countMatches(f, '$') == 0).collect(Collectors.toList());

        collect.forEach(s->{
            String[] sub = null;
            String field = null;
            sub = StringUtils.split(s,"@", 3);

            field = sub[0].trim();
            System.out.println(field);
        });

   }

   @Test
    public void test5(){
       Map<String,Object> map = new HashMap<>();
       map.put("name","jh");
   }
}
