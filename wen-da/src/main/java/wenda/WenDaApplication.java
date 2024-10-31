package wenda;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = {"wenda.mapper"})
@SpringBootApplication
public class WenDaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WenDaApplication.class, args);
    }

}
