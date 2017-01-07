import java.math.RoundingMode;
import java.math.BigDecimal;

class Register {
  private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_EVEN;
  public static final BigDecimal REGULAR_TAXES = new BigDecimal("0.10"); //10% tax
  public static final BigDecimal IMPORTED_TAXES = new BigDecimal("0.05"); //5% tax
  private BigDecimal totalTax = new BigDecimal("0.00"); 
  private BigDecimal totalPrice = new BigDecimal("0.00");
  
  //applies tax to a price and return the finalprice
  public BigDecimal applyTaxes( BigDecimal price, BigDecimal taxRate) {
    BigDecimal roundingFactor = new BigDecimal("0.05");
    
    BigDecimal tax = price.multiply(taxRate); //multiply price by taxrate
    tax = tax.divide(roundingFactor); //divide tax by 0.05
    tax = tax.setScale(0, BigDecimal.ROUND_UP); //round UP 8.23->9, 8.7->9
    tax = tax.multiply(roundingFactor); //finally multiply by 0.05

    //always make sure to format to CURRENCY before storing the result
    BigDecimal finalPrice = formatToCurrency(price.add(tax));
    this.totalTax = formatToCurrency(this.totalTax.add(tax));
    this.totalPrice = formatToCurrency(this.totalPrice.add(finalPrice));

    return finalPrice;
  }

  private BigDecimal formatToCurrency(BigDecimal amount) {
    return amount.setScale(2, DEFAULT_ROUNDING);
  }

  //prints product in the format specified
  public void printProductInfo(Product product, BigDecimal taxRate) {
    String name = product.getName();
    int quantity = product.getQuantity();
    BigDecimal price = product.getPrice();
    BigDecimal priceAndTax = applyTaxes(price, taxRate);

    System.out.println(quantity + " " + name + ": " + priceAndTax);
  }

  //prints totals stored in the register
  public void printTotals() {
    System.out.println("Sales Taxes: " + getTotalTax());
    System.out.println("Total: " + getTotalPrice());
  }

  //used for testing purposes
  public BigDecimal getTotalTax() {
    return this.totalTax;
  }

  //used for testing purposes
  public BigDecimal getTotalPrice() {
    return this.totalPrice;
  }
}