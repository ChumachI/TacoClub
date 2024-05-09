package sia.tacocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*  
@SpringBootApplication – это составная аннотация, объединяющая
три другие аннотации:
- @SpringBootConfiguration – определяет этот класс как класс кон-
	фигурации. В данный момент в этом классе не определяется
	никаких конфигурационных параметров, но если понадобится,
	в него можно добавить настройки Spring Framework. Эта аннота-
	ция, по сути, является специализированной формой аннотации
	@Configuration;
- @EnableAutoConfiguration – включает автоконфигурацию Spring
	Boot. Подробнее об автоконфигурации мы поговорим позже,
	а пока просто имейте в виду, что эта аннотация сообщает Spring
	Boot о необходимости автоматически настраивать любые ком-
	поненты, которые могут вам понадобиться;Инициализация приложения Spring
	39
- @ComponentScan – включает сканирование компонентов. Меха-
	низм сканирования позволяет объявлять другие классы с анно-
	тациями, такими как @Component, @Controller и @Service, чтобы
	фреймворк Spring автоматически обнаруживал и регистрировал
	их как компоненты в контексте приложения Spring. 
*/
@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		/*Метод run() принимает два параметра: класс конфигурации и аргументы командной строки. */
		SpringApplication.run(TacoCloudApplication.class, args);
	}

}
