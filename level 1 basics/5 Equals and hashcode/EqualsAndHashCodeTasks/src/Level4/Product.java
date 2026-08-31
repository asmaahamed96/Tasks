package Level4;

import java.util.Objects;

public class Product {
    private final String code;
    private final double price;

    public Product(String code, double price) {
        this.code = code;
        this.price = price;
    }

    public String getCode() { return code; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Product{code='" + code + "', price=" + price + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;
        return Objects.equals(this.code, ((Product) obj).code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
