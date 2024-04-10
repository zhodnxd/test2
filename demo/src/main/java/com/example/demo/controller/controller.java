package com.example.demo.controller;

import com.example.demo.message.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
public class controller {
        @Autowired
        private StudentService studentService;
        @GetMapping("/ListAll")
        @Transactional
        public List<Student>index(){
            return studentService.listAll();
        }
    @GetMapping("/add")//添加
    @Transactional
    public List<Student> add() {
        return studentService.add("张三","123456");
    }
    @GetMapping("/update")//修改
    @Transactional
    public List<Student> update(){
        return studentService.update("李四");
    }
    @GetMapping("/delete")//删除
    @Transactional
    public List<Student> delete(){
        return studentService.delete("张三");
    }
    @GetMapping("/QueryUserName")
    @Transactional
    public List<Student> contextLoads(){
        return studentService.contextLoads("李四");
    }
    }

