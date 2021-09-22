package com.br.gubee.domains.products;

import com.br.gubee.utils.Json2Java;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final Json2Java json2Java;

    @Override
    public List<Product> listAll() {
        return json2Java.json2java();
    }

    @Override
    public List<Product> listByStack(List<String> filterList) {
        List<Product> products = json2Java.json2java();
        List<Product> filteredProducts = products.stream()
                .filter(product -> filterStack(product, filterList))
                .collect(Collectors.toList());
        return filteredProducts;
    }

    private boolean filterStack(Product product, List<String> listFilter) {
        List<String> filteredStack = product.getStack().stream()
                .filter(listFilter::contains)
                .collect(Collectors.toList());
        return !filteredStack.isEmpty();
    }

}
