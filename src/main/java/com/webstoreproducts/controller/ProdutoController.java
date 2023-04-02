package com.webstoreproducts.controller;

import com.webstoreproducts.model.Product;
import com.webstoreproducts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping()
public class ProdutoController {
//    private final ProdutoRepository repository;
//    public ProdutoController (ProdutoRepository repository){
//        this.repository = repository;
//    }

    @Autowired
    private ProductRepository repository;

    @GetMapping("/")
    public String welcomeHome() {
        return "Welcome! You are using Spring Boot!";
    }

    @PostMapping("/products")
    public void postProduct(@RequestBody Product product) {
        repository.save(product);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findProductByID(@PathVariable("id") Long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok().body(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @PutMapping("/products/{id}")
//    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
//        Optional<Product> product = repository.findById(id);
//        if(product.isPresent()){
//            //código que adiciona o objeto passado no body request no registro consultado.
//        }


    @PutMapping("/products/{id}")
        Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id){
        return repository.findById(id)
                .map(product -> {
                    product.setItem(newProduct.getItem());
                    product.setManufacturer(newProduct.getManufacturer());
                    product.setMemorySize(newProduct.getMemorySize());
                    product.setStorageSize(newProduct.getStorageSize());
                    return repository.save(newProduct);
                })
                .orElseGet(()-> {
                    newProduct.setId(id);
                    return repository.save(newProduct);
                });
    }

}


