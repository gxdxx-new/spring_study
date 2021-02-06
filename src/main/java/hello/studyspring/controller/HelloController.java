package hello.studyspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!");
        //hello.html로 이동
        return "hello";
    }

    //ViewResolver가 동작
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    //@ResponseBody : HTTP의 body에 return값을 직접 넣어줌
    @GetMapping("hello-spring")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    //JSON으로 반환
    //@ResponseBody가 있으면 HttpMessageConverter가 동작
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    //HelloController 클래스 내에서 사용 가능
    static class Hello {
        private String name;

        //gettersetter : Alt + Insert
        //자바 빈 규약(get, set 메서드를 통해서 접근 가능하게 함), property 접근방식이라고도 함
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
