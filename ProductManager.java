import java.math.BigDecimal;

class ProductManager {
  //used a string for easier use of the String.contains method saved me an extra loop in the long-run
  private String taxExcemptProducts = "books, chocolates, pills, meat, medical, medicine";

  //reads a text line and return a product Object
  public Product formatProduct(String textString) {
    String[] array = textString.split(" ");

    int quantity = Integer.parseInt(array[0]);
    BigDecimal price = new BigDecimal(array[array.length - 1]);
    String name = "";
    
    //here we extract the whole name of the product
    //skip first and last 2 items( quantity, the word "at" and "price");
    for(int i = 1; i < array.length - 2; i++) {
      name += array[i];

      //add a space unless its the the last word
      if (i != array.length - 3) {
        name += " ";
      }
    }

    //make a product and return it
    return new Product(name, price, quantity);
  }

  public Boolean isImported(String productName) {
    if (productName.contains("imported")) {
      return true;
    }

    return false;
  }

  public Boolean isTaxExcempt(String productName) {
    String[] nameInWords = productName.split(" ");
    for(int i = 0; i < nameInWords.length; i++) {
      
      //if the string of tax exempt items contains any word of the product name
      //then the item is tax excempt.
      if (this.taxExcemptProducts.contains(nameInWords[i])) {
        return true;
      }
    }

    return false;
  }
}