package hello.hellospring.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class HelloController {

    @GetMapping("hello")//주소값 hello 매칭

    public String hello(Model model) {
        model.addAttribute("data", "hello!"); //key = data, value = hello!
        return "hello"; //hello.html 에 넘김
    }

    @GetMapping("hello-mvc")//

    public String helloMvc(@RequestParam("name") String name, Model model) { // 외부에서 파라미터를 받음
        model.addAttribute("name", name); //
        return "hello-template"; //
    }

    @GetMapping("hello-string")
    @ResponseBody                   // 데이터를 직접넣어주겠다

    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
