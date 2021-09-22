package com.br.gubee.utils;

import com.br.gubee.domains.products.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Json2Java {

    public List<Product> json2java() {
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(
                    new File("gubee-json.json"),
                    new TypeReference<List<Product>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

}
