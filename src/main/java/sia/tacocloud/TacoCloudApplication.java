package sia.tacocloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sia.tacocloud.entity.Ingredient;
import sia.tacocloud.entity.Ingredient.Type;
import sia.tacocloud.repository.IngredientRepository;

@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

	/*
	 * Ключевое различие между CommandLineRunner и ApplicationRun-
	 * ner заключается в параметре метода run(). В CommandLineRunner этот
	 * метод принимает строку со всеми параметрами командной строки,
	 * а ApplicationRunner – параметр типа ApplicationArguments, предлага-
	 * ющий методы для доступа к отдельным аргументам, извлеченным из
	 * командной строки.
	 * Например, предположим, что мы решили добавить в приложе-
	 * ние поддержку аргументов командной строки, таких как "--version
	 * 1.2.3", и анализировать их в нашем компоненте-загрузчике. При ис-
	 * пользовании CommandLineRunner нам пришлось бы отыскать в массиве
	 * подстроку «--version», а затем выбрать следующее за ней значение.
	 * ApplicationRunner, напротив, позволяет прямо запросить из Applica-
	 * tionArguments значение для аргумента «--version»:
	 * public ApplicationRunner dataLoader(IngredientRepository repo) {
	 * return args -> {
	 * List<String> version = args.getOptionValues("version");
	 * ...
	 * };
	 * }
	 */
	@Bean
	public CommandLineRunner dataLoader(IngredientRepository repository) {
		return args -> {
			repository.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
			repository.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
			repository.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
			repository.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
			repository.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
			repository.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
			repository.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
			repository.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
			repository.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
			repository.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
		};
	}
}
