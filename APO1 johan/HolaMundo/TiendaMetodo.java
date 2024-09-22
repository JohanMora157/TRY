import java.util.Scanner;

public class TiendaMetodo {
    public static void main(String[] x) {
Scanner scanner = new Scanner(System.in);
System.out.println("Digite el numero de dulces");
int cantidad = scanner.nextInt();
final int dulce =300;
final double iva=0.16;
double total =calcularTotal(cantidad, dulce, iva);
mostrarEnConsola(total);

        
    }

    //cantidad de dulces,valor de dulces, impuesto


public static double calcularTotal(int cantidaddulce, int valorDulce, double valorImpuesto){
    double total=0, IVA=0.16;


    total += cantidaddulce*valorDulce;

    total *=(1+IVA);

    
    return total;
} 

public static void mostrarEnConsola(double total){

int truncado = (int)total;

System.out.println("el valor total es:" +truncado);
    
}



}
