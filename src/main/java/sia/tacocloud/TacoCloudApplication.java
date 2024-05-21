package sia.tacocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		/*Метод run() принимает два параметра: класс конфигурации и аргументы командной строки. */
		SpringApplication.run(TacoCloudApplication.class, args);
	}
}
