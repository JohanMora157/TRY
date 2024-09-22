import java.util.Scanner;

public class REPASOAPO {
    private static final int YEARNOW = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
System.out.println("--de que año es tu vehiculo--");
System.out.println("digite el año de su vehiculo");
int agest = scanner.nextInt();
System.out.println("ingrese el precio de venta");
double price = scanner.nextDouble();
int añoref = 2024;
int modelo = (int) calcular_año(agest, añoref);
double prices=PrecioJusto(price, modelo);
printModelo(modelo, prices);



 
}
    public static double calcular_año(int edadCarro, int año){
       
        
       int  modelo = año-edadCarro;
    
       

    return modelo;
    }

    public static void printModelo(int año, double precio){

        
        System.out.println("este es el modelo de su vehiculo "+año);
        System.out.println("Este es el precio justo para el vehiculo "+(int)precio);




    }
 public static double PrecioJusto(double price, int añosCarro){

   
double precioT= (price-(price*(añosCarro/100.0)));



    return precioT;
 }


}
