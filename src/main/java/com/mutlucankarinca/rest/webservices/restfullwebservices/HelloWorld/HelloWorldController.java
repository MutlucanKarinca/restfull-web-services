package com.mutlucankarinca.rest.webservices.restfullwebservices.HelloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

//@Controller
@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;
    //method : GET
    //url : /hello-world

   //@RequestMapping(method = RequestMethod.GET,path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World!";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s",name));
    }

    @GetMapping(path = "/hello-world-inter")
    public String helloWorldInternationalization(){
        //en= hello world
        //nl= Goedo morgen
        //fr= Bonjour
        //return "Hello World!";
        return messageSource.getMessage("good.morning.messages",null,"Default Message", LocaleContextHolder.getLocale());
    }

}
