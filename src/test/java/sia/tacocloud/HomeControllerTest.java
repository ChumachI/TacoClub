package sia.tacocloud;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import sia.tacocloud.controller.HomeController;

//Тест для HomeController
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    //Внедрить MockMvc
    private MockMvc mockMvc;

    @Test
    public void testHomePage() throws Exception {
        //Выполнить запрос GET /
        mockMvc.perform(get("/"))
        //Ожидается код ответа HTTP 200
        .andExpect(status().isOk())
        //Ожидается имя представления home
        .andExpect(view().name("home"))
        //Ожидается наличие строки «Welcome to...»
        .andExpect(content().string(containsString("Welcome to...")));
        
    }

    
}
