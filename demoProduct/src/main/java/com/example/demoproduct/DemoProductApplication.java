package com.example.demoproduct;

import com.example.demoproduct.entity.Product;
import com.example.demoproduct.repo.ProductReponsitory;
import com.example.demoproduct.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoProductApplication {


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private  UserRepository userRepository;
    @Autowired
            private  ProductReponsitory productReponsitory;
    public static void main(String[] args) {
        SpringApplication.run(DemoProductApplication.class, args);
    }


    @Bean
    CommandLineRunner test(){
        return args -> {
            for (int i=1; i<=10; i++) {

                Product product=new Product(i,"Product"+i);
                productReponsitory.save(product);
            }
        };
    }
}
