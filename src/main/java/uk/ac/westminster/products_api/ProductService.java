package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    // private so the controller cannot touch the list directly
    private List<Product> products = new ArrayList<>();

    // the next id to give out, starts at 3 because 1 and 2 are used below
    private Long nextId = 3L;

    // runs when Spring creates the service, adds two sample products
    public ProductService() {
        products.add(new Product(1L, "Laptop", 999.99));
        products.add(new Product(2L, "Mouse", 19.99));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    // business rule: the service gives every new product the next id
    public Product addProduct(Product product) {
        product.setId(nextId);
        nextId += 1L;
        products.add(product);
        return product;
    }

    // returns true if a product was removed, false if the id was not found
    public boolean deleteProduct(Long id) {
        return products.removeIf(p -> p.getId().equals(id));
    }
}