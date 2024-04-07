package com.example.demoproduct.serivces;

import com.example.demoproduct.entity.Product;
import com.example.demoproduct.entity.User;
import com.example.demoproduct.repo.ProductReponsitory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.retry.annotation.Retry;

import java.util.List;

@Slf4j
@Service
public class ProService {
    private final ProductReponsitory productReponsitory;

    private final RestTemplate restTemplate;

    public ProService(ProductReponsitory productReponsitory, RestTemplate restTemplate) {
        this.productReponsitory = productReponsitory;
        this.restTemplate = restTemplate;
    }

    @Retry(name = "retryApi")
    public List<Product> getlistPro(){
        List<Product> productList = productReponsitory.findAll();
        for (Product p: productList) {
            User user = restTemplate.getForObject("http://localhost:8081/User/users/"+p.getId(), User.class);
            p.setUser(user);
        }
        return productList;
    }
}
