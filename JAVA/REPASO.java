import java.util.Scanner;

public class REPASO{
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        /*System.out.println("Hi, type something");
        String typing = scanner.nextLine();

        System.out.println("You type = "+typing);*/

        //Make a Fruit Store

        //name of store

        System.out.println("Type the name of the store");
        String nameStore = scanner.nextLine();

        //Products 
 System.out.println("Type the Name of the product 1");
 String product1 = scanner.nextLine(); 
 System.out.println("Type the Name of the product 2");
 String product2 = scanner.nextLine(); 
 System.out.println("Type the Name of the product 3");
 String product3 = scanner.nextLine(); 
 System.out.println("Type the Name of the product 4");
 String product4 = scanner.nextLine(); 
 //Price of the products

 System.out.println("Type the price of the "+product1);
 int productPrice1 = scanner.nextInt(); 
 System.out.println("Type the price of the "+product2);
 int productPrice2 = scanner.nextInt(); 
 System.out.println("Type the price of the "+product3);
 int productPrice3 = scanner.nextInt();
 System.out.println("Type the price of the "+product4);
 int productPrice4 = scanner.nextInt(); 

 //Print products

 System.out.println("Products of "+nameStore+"\n"+product1+" price "+productPrice1+"\n"+product2+" price "+productPrice2+"\n"+product3+" price "+productPrice3+"\n"+product4+" price "+productPrice4);


 //Shopping

 System.out.println("Shop");
 System.out.println("how many "+product1+" do you want?");
 int shoP1 = scanner.nextInt();
 System.out.println("how many "+product2+" do you want?");
 int shoP2 = scanner.nextInt();
 System.out.println("how many "+product3+" do you want?");
 int shoP3 = scanner.nextInt();
 System.out.println("how many "+product4+" do you want?");
 int shoP4 = scanner.nextInt();

 // Calculate
double subTotal, Total;

subTotal = (shoP1*productPrice1)+(shoP2*productPrice2)+(shoP3*productPrice3)+(shoP4*productPrice4);

// discount 10%

Total=subTotal-(subTotal*0.1);

//print the total and subtotal
System.out.println("Subtotal = "+subTotal);

System.out.println("Discount 10% "+(subTotal*0.1));

System.out.println("Total of the shopping = "+(int)Total);
 


 

















    }
}