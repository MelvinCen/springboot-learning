package cn.melvin;

import com.battcn.swagger.annotation.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2Doc
public class springbootSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(springbootSwaggerApplication.class, args);
	}
}
