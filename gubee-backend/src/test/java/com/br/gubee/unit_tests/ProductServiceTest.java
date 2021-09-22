package com.br.gubee.unit_tests;

import com.br.gubee.domains.products.Product;
import com.br.gubee.domains.products.ProductService;
import com.br.gubee.utils.Json2Java;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private Json2Java json2Java;

    List<String> stackList1 = List.of("Java 10", "Kotlin", "Kafka", "Event Stream", "Redis", "MongoDB");
    List<String> stackList2 = List.of("Big Data Analytics", "Hadoop", "Kafka", "Pig", "Cassandra");
    List<String> targetMarkets1 = List.of("Ecommerce", "ERP", "Lojista que não desejam possuir ecommerce");
    List<String> targetMarkets2 = List.of("Ecommerce", "Telecom", "Venda direta", "Mobile First", "Digital Onboarding");

    Product product1 = new Product("Gubee Integrador",
            "Ferramenta de integração para marketplaces", stackList1, targetMarkets1);
    Product product2 = new Product("Gubee AntiFraude",
            "Ferramenta especialistas em detecção e prevenção à fraude", stackList2, targetMarkets2);

    @Test
    public void listing_Products_ReturningAllProducts() {
        List<Product> productsListed = productService.listAll();
        List<Product> productsFromJson = json2Java.json2java();

        assertThat(productsListed, is(productsFromJson));
        assertThat(productsListed, not(IsEmptyCollection.empty()));
    }

    @Test
    public void listing_FilteredProducts_Returning_OneFilteredProducts() {
        List<String> stringFilter = List.of("Java 10");

        List<Product> products = List.of(product1);

        List<Product> productsFiltered = productService.listByStack(stringFilter);

        assertThat(products, is(productsFiltered));
    }

    @Test
    public void listing_FilteredProducts_Returning_MoreThanOneFilteredProduct() {
        List<String> stringFilter = List.of("Java 10", "Hadoop");

        List<Product> products = List.of(product1, product2);

        List<Product> productsFiltered = productService.listByStack(stringFilter);

        assertThat(products, is(productsFiltered));
    }

}
