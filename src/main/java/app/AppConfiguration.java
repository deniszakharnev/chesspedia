package app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("service;controller")
@MapperScan("mybatis")
public class AppConfiguration {
}
