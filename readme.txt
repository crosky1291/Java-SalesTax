//PROBLEM 
Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.
 
When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid.  The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.
 
Write an application that prints out the receipt details for these shopping baskets...
 
INPUT:
 
Input 1:
1 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85
 
Input 2:
1 imported box of chocolates at 10.00
1 imported bottle of perfume at 47.50
 
Input 3:
1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 box of imported chocolates at 11.25
 
OUTPUT:
 
Output 1:
1 book : 12.49
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 29.83
 
Output 2:
1 imported box of chocolates: 10.50
1 imported bottle of perfume: 54.65
Sales Taxes: 7.65
Total: 65.15
 
Output 3:
1 imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 9.75
1 imported box of chocolates: 11.85
Sales Taxes: 6.70
Total: 74.68

//RULES
1. There must be a way to supply the application with the input data via text file.


//TO RUN APP

1. Use the terminal to navigate to the SalesTax folder which is the root of the directory.
2. Assuming you have java installed run the command: "javac App.java" to compile all the classes needed.
3. Run the command "java App" to run the App.
4. You should see a Shopping Basket printed.

//TO EDIT SHOPPING BASKET
1. Open the "inputs.txt" file
2. Edit it as you like providing 1 line of text for each item
3. Format the textline in the form of ("quantity itemName at price") to receive a correct output.

//RULES
the app only handles 1 shopping basket at a time, however you can add as many items as you like.

//DESIGN PATTERN
1. ProductManager class is responsible for putting the text information provided, into a product,
   and is who you go to, to ask things such as if the product is imported or tax excempt.

2. The Product class is a representation of a product( for example: its name, price or the quantity).

3. Finally the Register class is responsible for knowing the tax-rates and applying the tax amount 
   to products depending on their price, as well as printing information of the product and price totals of your Shopping Basket.

//There is a TEST-CLASS file for each of the main 3 classes(ProductTest, ProductMangerTest and RegisterTest).

//TO RUN THE TESTS
1. navigate to the SalesTax folder.
2. download JUnit into this directory.
3. compile it: javac -cp .:junit-4.12.jar:hamcrest-core-1.3  < Filename.java HERE >
4. run it: java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore < INSERT TEST-CLASSNAME HERE >
5. that command will run JUNIT and it will show in the terminal if tests passed or not.