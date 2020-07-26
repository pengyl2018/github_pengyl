package com.example.demo;

import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @Autowired
    TestService testService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "hello springboot";
    }

    @RequestMapping(value = "/feboo/{number}", method = RequestMethod.GET)
    public int computeFebonacci(@PathVariable("number") String number) {
        Integer num = Integer.valueOf(number);
        return testService.getFebonacci(num);
    }
}
