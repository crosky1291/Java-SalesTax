import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

class App {
  public static void main(String[] args) throws java.io.IOException {
    String file = "inputs.txt";
    FileReader fr = new FileReader(file);
    BufferedReader br = new BufferedReader(fr);
    String textLine;

    //initialize the register
    //it will calculate taxes and print the products
    Register register = new Register();

    //create an instance of the product manager which turns text into a product object.
    //and knows information about the product
    ProductManager pM = new ProductManager();
    
    int lineNumber = 0;
    while((textLine = br.readLine()) != null) {

      //the text formatter return a correctly fortmatted product object.
      Product product = pM.formatProduct(textLine);

      //ask the manager weather the product is imported and tax excempt.
      Boolean isImported = pM.isImported(product.getName());
      Boolean isTaxExcempt = pM.isTaxExcempt(product.getName());
      BigDecimal taxRate = new BigDecimal("0.00");

      if (isImported) {
        taxRate = taxRate.add(register.IMPORTED_TAXES);
      }

      //only apply taxes if is NOT tax excempt.
      if ( !isTaxExcempt) {
        taxRate = taxRate.add(register.REGULAR_TAXES);
      }
      
      //tell the register to print the product
      register.printProductInfo(product, taxRate);
      
      lineNumber++; //go on to the next product
    }
    br.close();

    //tell register to print the totals after all products have been processed.
    register.printTotals();
  }
}