package com.br.gubee.domains.products;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.listAll();
    }

    public List<Product> listByStack(List<String> filter) {
        return productRepository.listByStack(filter);
    }

}
