import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;

public class ProductTest {

  @Test
  public void getsNameQuantityAndPriceOfProduct() throws Exception {
    Product product = new Product("apple", new BigDecimal("1.85"), 2);

    assertEquals("apple", product.getName());
    assertEquals(new BigDecimal("1.85"), product.getPrice());
    assertEquals(2, product.getQuantity());
  }
}