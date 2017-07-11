package lm.com.IMDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ImdbApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ImdbApplication.class, args);
	}
	
	@Bean
	public Docket swaggerSettings() {
		ApiInfo apiTitle = new ApiInfo("Movie Database", "Nick and Lucas's Movie Database", null, null, null, null, null);
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiTitle)
				.pathMapping("/");
	}
}
