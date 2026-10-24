package uk.ac.westminster.products_api;

// A PhysicalProduct IS-A Product because it has an id, name and price like
// every product, and can be used anywhere a Product is expected.
// A ShoppingCart is NOT a Product because it contains products, so it
// should hold them in a list instead of extending Product (HAS-A).
public class PhysicalProduct extends Product {

    private double weightKg;
    private String dimensions;

    // empty constructor, Jackson needs it for POST requests
    public PhysicalProduct() {
    }

    public PhysicalProduct(Long id, String name, double price,
                           double weightKg, String dimensions) {
        super(id, name, price);   // must be the first line
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }
}