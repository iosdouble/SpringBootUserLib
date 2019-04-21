package com.example.springboot.controller;

import com.example.springboot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName HelloController
 * @Author nihui
 * @Date 2019/4/21 17:32
 * @Version 1.0
 * @Description TODO
 */

/**
 * @RestController
 * Spring4中新加入的这个注解，在之前的时候需要返回JSON数据的时候需要同时使用@ResponseBody和@Controller
 * 而这个注解就是将上面的两个注解合并成了一个注解，可以通过查看源码得到。
 */
@RestController
public class HelloController {

    /**
     * 以下的这两个注解在使用时候是等价的，任意选择其中一种方式即可
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    //@GetMapping(value = "/hello")

    /**
     * @RequestMapping
     * 此注解即可以作用在控制器的某个方法上，也可以作用在此控制器类上。也就是在类上面标注这个注解
     * 当控制器在类级别上添加@RequestMapping 注解时，这个注解会应用到控制器的所有处理器方法上。
     * 处理器方法上的@RequestMapping 注解会对类级别上的@RequestMapping 的声明进行补充。
     */
    public String sayHello(){
        return "Hello World!";
    }

    /**
     * 通过@Value注解来获取到配置属性值
     * 可以通过这种方式将配置文件中的值注入到实际使用的操作中
     *
     */
    @Value("${name}")
    private String name;
    @GetMapping(value = "/who")
    public String whoSayHello(){
        return "Hello"+name;
    }
    //http://localhost:8080/who  Hellonihui123

    @Autowired
    private Person person;
    @GetMapping(value = "/person")
    public String person(){
        return "Hello " + person.getName()+ ",and Happy birthday"+person.getAge();
    }
    //http://localhost:8080/person  Hello nihui,and Happy birthday24

    /**
     * @PathVaribale 获取 url 中的数据
     * @RequestParam 获取请求参数的值
     * @GetMapping 组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写
     * @PostMapping 组合注解，是@RequestMapping(method = RequestMethod.POST)的缩写
     */

    @RequestMapping(value = "/hello/{id}",method = RequestMethod.GET)
    public String pathVarible(@PathVariable("id") Integer id){
        return "Hello " +id;
    }

    @RequestMapping(value = "/hello/{id}/{name}",method = RequestMethod.GET)
    public String pathVarible(@PathVariable("id") Integer id,@PathVariable("name") String name){
        return "Hello" + id+name;
    }
    //请求方式 localhost:8080/hello/id

    @RequestMapping(value = "/hello",method = RequestMethod.GET )
    public String RequestParam(@RequestParam("id") Integer id){
        return "Hello" + id;
    }
    //请求方式 localhost:8080/hello?id=1000


}
