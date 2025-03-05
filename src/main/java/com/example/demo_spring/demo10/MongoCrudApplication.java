package com.example.demo_spring.demo10;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class MongoCrudApplication {
    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(MongoCrudApplication.class, args);
    }

    @PostMapping("/products/create")
    public Product createProduct(@RequestBody Product product) {
        // After post a product, mongodb will add a collection "product"
        return mongoTemplate.save(product);
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable(name = "id") String id) {
        return mongoTemplate.findById(id, Product.class);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        // Return a json array
        return mongoTemplate.findAll(Product.class);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable(name = "id") String id, @RequestBody Product updatedProduct) {
        updatedProduct.setId(id); // Ensure the ID is set
        return mongoTemplate.save(updatedProduct);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable(name = "id") String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Product.class);
    }

    public static class Product {
        @Id
        private String id;
        private String name;
        private double price;

        public Product() {
        }

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
