package com.br.gubee.domains.products;

import java.util.List;

interface ProductRepository {

    List<Product> listAll();

    List<Product> listByStack(List<String> filter);

}
