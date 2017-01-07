import java.math.BigDecimal;

public class Product {
  private String name;
  private BigDecimal price;
  private int quantity;

  public Product(String name, BigDecimal price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public String getName() {
    return this.name;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public BigDecimal getPrice() {
    return this.price;
  }

  @Override
  public String toString() {
    return "I am a " + this.name + ", and my cost is " + this.price + ".";
  }
}