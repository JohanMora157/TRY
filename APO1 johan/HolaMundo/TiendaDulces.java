/* 
ANALISIS
    ENTRADAS:numero de dulces a comprar

    SALIDAS:total sin impuesto, total con impuesto, total del impuesto

    EJEMPLOS:numero de dulces=20---subtotal sin impuesto=6000---impuesto=960---total=6960

*/

import java.util.Scanner;
public class TiendaDulces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

final double TAXES = 0.16; 
int price = 300;

System.out.println("---TIENDA CAROLINA---");
System.out.println("Digite el numero de dulces:");
int numDulces = scanner.nextInt();

int subTotal;
double total;

subTotal=price*numDulces;

total=(subTotal*TAXES)+subTotal;
int totalFinal = (int)total;

System.out.println("El total sin impestos es :"+subTotal);
System.out.println("El impuesto agregado(16%) es de :"+(int)(subTotal*TAXES));
System.out.println("El valor total es :"+totalFinal);


scanner.close();






    }
}
