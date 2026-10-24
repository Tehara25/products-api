package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    // one list holds both types because each IS-A Product
    private List<Product> products = new ArrayList<>();

    // ids 1 and 2 are used by the sample products
    private Long nextId = 3L;

    public ProductService() {
        products.add(new DigitalProduct(
                1L, "Clean Code (E-book)", 29.99,
                "/downloads/clean-code.pdf", 4.2));
        products.add(new PhysicalProduct(
                2L, "27-inch Monitor", 249.99,
                5.4, "61cm x 41cm x 18cm"));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public Product addProduct(Product product) {
        product.setId(nextId);
        nextId += 1L;
        products.add(product);
        return product;
    }

    public boolean deleteProduct(Long id) {
        return products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }
}