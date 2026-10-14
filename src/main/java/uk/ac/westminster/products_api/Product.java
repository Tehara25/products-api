package uk.ac.westminster.products_api;



public class Product {

    private Long id;
    private String name;
    private double price;

    // empty constructor, needed later when JSON arrives in a POST request
    public Product() {
    }

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // getters, the doors Jackson uses to read the data
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
