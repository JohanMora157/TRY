import java.util.Scanner;


public class Tienda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
//cantidad
System.out.println("Digite la cantidad de bananos que quiere comprar");
int CantBanano = scanner.nextInt();
System.out.println("Digite la cantidad de manzanas que quiere comprar");
int CantManzana = scanner.nextInt();


//precios

int banano = 800, manzana= 1000;

//sub total

double subtotal = 0;
double subBanano = (banano*CantBanano);
double subManzana = (manzana*CantManzana);

System.out.println("Sub total del banano : "+subBanano);
System.out.println("-Sub total de la manzana : "+subManzana);

subtotal = subBanano+subManzana;

System.out.println("--Sub total sin descuento : "+subtotal);
//Descuento 10%
double Desq = subtotal * 0.1;

System.out.println("---Descuento aplicado : "+Desq);


 double Total = subtotal - Desq;

//Tolal

System.out.println("----El total de la compra fue : "+Total);





scanner.close();

    }
    
}
