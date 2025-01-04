package hello2.hello_spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller   //controller 어노테이션 적어주기
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","Hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody     //응답 body부에 data 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello"+name;   //data를 그대로 내려줌, html 필요없음!!
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {  //객체
        Hello hello=new Hello();    //객체 만들고
        hello.setName(name);   //name 넘김
        return hello;
    }
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
