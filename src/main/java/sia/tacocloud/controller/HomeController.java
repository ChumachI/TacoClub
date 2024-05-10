package sia.tacocloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Контроллер
@Controller
public class HomeController {
    //Обрабатывает запросыс корневым путем "/"
    @GetMapping("/")
    public String home() {
        //Возвращает имя представления
        return "home";
    }    
}
