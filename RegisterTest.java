import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;

public class RegisterTest {

  @Test
  public void appliesTaxToAPrice() throws Exception {
    Register register = new Register();
    BigDecimal price1  = new BigDecimal("10");
    BigDecimal taxRate1  = new BigDecimal("0.05"); //5% tax
    BigDecimal answer1 = new BigDecimal("10.50");
    BigDecimal price2  = new BigDecimal("27.99");
    BigDecimal taxRate2  = new BigDecimal("0.15"); //15% tax
    BigDecimal answer2 = new BigDecimal("32.19");
    BigDecimal price3  = new BigDecimal("18.99");
    BigDecimal taxRate3  = new BigDecimal("0.10"); //10% tax
    BigDecimal answer3 = new BigDecimal("20.89");
    BigDecimal price4  = new BigDecimal("0.85");
    BigDecimal taxRate4  = new BigDecimal("0"); //no tax
    BigDecimal answer4 = new BigDecimal("0.85");

    assertEquals(answer1, register.applyTaxes(price1, taxRate1));
    assertEquals(answer2, register.applyTaxes(price2, taxRate2)); 
    assertEquals(answer3, register.applyTaxes(price3, taxRate3)); 
    assertEquals(answer4, register.applyTaxes(price4, taxRate4)); 
  }

  @Test
  public void verifiesTotalTax() throws Exception {
    Register register = new Register();
    assertEquals(new BigDecimal("0.00"), register.getTotalTax());

    BigDecimal price1 = new BigDecimal("10.00");
    BigDecimal taxRate1 = new BigDecimal("0.05"); //5% tax
    register.applyTaxes(price1, taxRate1);
    assertEquals(new BigDecimal("0.50"), register.getTotalTax());

    BigDecimal price2 = new BigDecimal("27.99");
    BigDecimal taxRate2 = new BigDecimal("0.15"); //15% tax
    register.applyTaxes(price2, taxRate2);
    assertEquals(new BigDecimal("4.70"), register.getTotalTax());

    BigDecimal price3 = new BigDecimal("18.99");
    BigDecimal taxRate3 = new BigDecimal("0.10"); //10% tax
    register.applyTaxes(price3, taxRate3);
    assertEquals(new BigDecimal("6.60"), register.getTotalTax());

    BigDecimal price4 = new BigDecimal("0.85");
    BigDecimal taxRate4 = new BigDecimal("0"); //no tax
    register.applyTaxes(price4, taxRate4);
    assertEquals(new BigDecimal("6.60"), register.getTotalTax());
  }

  @Test
  public void verifiesTotalPrice() throws Exception {
    Register register = new Register();
    assertEquals(new BigDecimal("0.00"), register.getTotalPrice());

    BigDecimal price1 = new BigDecimal("10.00");
    BigDecimal taxRate1 = new BigDecimal("0.05"); //5% tax
    register.applyTaxes(price1, taxRate1);
    assertEquals(new BigDecimal("10.50"), register.getTotalPrice());

    BigDecimal price2 = new BigDecimal("27.99");
    BigDecimal taxRate2 = new BigDecimal("0.15"); //15% tax
    register.applyTaxes(price2, taxRate2);
    assertEquals(new BigDecimal("42.69"), register.getTotalPrice());

    BigDecimal price3 = new BigDecimal("18.99");
    BigDecimal taxRate3 = new BigDecimal("0.10"); //10% tax
    register.applyTaxes(price3, taxRate3);
    assertEquals(new BigDecimal("63.58"), register.getTotalPrice());

    BigDecimal price4 = new BigDecimal("0.85");
    BigDecimal taxRate4 = new BigDecimal("0"); //no tax
    register.applyTaxes(price4, taxRate4);
    assertEquals(new BigDecimal("64.43"), register.getTotalPrice());
  }
}