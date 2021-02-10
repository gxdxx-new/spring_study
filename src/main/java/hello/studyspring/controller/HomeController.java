package hello.studyspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController { //static에 index.html을 무시하고 home.html을 실행시킴

    @GetMapping("/")
    public String home() {
        return "home"; //home.html 호충
    }
}
