import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;

public class ProductManagerTest {

  @Test
  public void formatProduct() throws Exception {
    ProductManager pM = new ProductManager();
    String textString1 = "1 box of imported chocolates at 11.25";
    Product product1 = pM.formatProduct(textString1);

    assertEquals("box of imported chocolates", product1.getName());
    assertEquals(new BigDecimal("11.25"), product1.getPrice());
    assertEquals(1, product1.getQuantity());
  }

  @Test
  public void isImported() throws Exception {
    ProductManager pM = new ProductManager();

    assertEquals(true, pM.isImported("box of imported chocolates"));
    assertEquals(false, pM.isImported("box of chocolates"));
  }

  @Test
  public void isTaxExcempt() throws Exception {
    ProductManager pM = new ProductManager();

    assertEquals(true, pM.isTaxExcempt("box of imported chocolates"));
    assertEquals(true, pM.isTaxExcempt("box of chocolates"));
    assertEquals(false, pM.isTaxExcempt("bottle of perfume"));
  }
}