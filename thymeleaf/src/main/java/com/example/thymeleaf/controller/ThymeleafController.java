package com.example.thymeleaf.controller;

import com.example.thymeleaf.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ThymeleafController
 * @Author nihui
 * @Date 2019/4/21 18:26
 * @Version 1.0
 * @Description TODO
 */
@Controller
@RequestMapping(value = "/student")
public class ThymeleafController {
   @RequestMapping(value = "/")
    public ModelAndView index(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"倪辉",24,"男"));
        studentList.add(new Student(2,"张无忌",18,"男"));
        studentList.add(new Student(3,"赵敏",16,"女"));
        studentList.add(new Student(4,"杨过",25,"男"));
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("studentList",studentList);
        return  modelAndView;
    }
}
