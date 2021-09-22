package com.br.gubee.domains.products;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> listAll() {
        return productService.listAll();
    }

    @PostMapping("/stack")
    public List<Product> listByStack(@RequestBody List<String> filter) {
        return productService.listByStack(filter);
    }

}
