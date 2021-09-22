package com.br.gubee.domains.products;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class Product {

    private String productName;
    private String description;
    private List<String> stack;
    private List<String> targetMarket;

    @JsonCreator
    public Product(@JsonProperty("productName") String productName, @JsonProperty("description") String description,
                   @JsonProperty("stack") List<String> stack, @JsonProperty("targetMarket") List<String> targetMarket) {
        this.productName = productName;
        this.description = description;
        this.stack = stack;
        this.targetMarket = targetMarket;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getStack() {
        return stack;
    }

    public List<String> getTargetMarket() {
        return targetMarket;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", stack=" + stack +
                ", targetMarket=" + targetMarket +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productName.equals(product.productName) && description.equals(product.description) && stack.equals(product.stack) && targetMarket.equals(product.targetMarket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, description, stack, targetMarket);
    }

}
