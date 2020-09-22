package dev.yoghurt.buildImage;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RouterFunctions.route;
import static org.springframework.web.servlet.function.ServerResponse.ok;

@SpringBootApplication(proxyBeanMethods = false)
public class BuildImageApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuildImageApplication.class, args);
	}

	@Bean
	public RouterFunction<ServerResponse> routes(MessageService messageService) {
		return route()
				.GET("/greet", req -> ok().body(messageService.greet()))
				.GET("/greet/{name}", req -> ok().body(messageService.greet(req.pathVariable("name"))))
                .build();
	}
}

@Service
class MessageService {
	Message greet() {
		return new Message("Hello, World.");
	}

	Message greet(String name) {
		return new Message("Hello, " + name + ".");
	}
}

@Data
@AllArgsConstructor
class Message {
	private String body;
}