package com.abinandh.demo;

import org.springframework.web.bind.annotation.RestController;
import org.hibernate.boot.model.relational.Sequence.Name;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/abinandh")
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "Spring Boot Running   very Successfully!";
    }

    @GetMapping("/goodMorning")
    public String goodMorning() {
        return "good morning";
    }
    
    @GetMapping("/{id}")
    public String goodMorningpara(@PathVariable long id) {
        return "good morning" +id;
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String name  ,@RequestParam String password) {
        return "Post  :::::     Name :"+name + "  Passward :" + password;
    }

    @PutMapping("/login")
    public String loginPut(@RequestBody  String name) {
        return "Put    ::::    Name :"+name;
    }
    

    
}