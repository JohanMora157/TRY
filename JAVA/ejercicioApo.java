import java.lang.Math;
import java.util.Scanner;


public class ejercicioApo {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
   boolean condition = false;
while (condition==false) {
    menu();
    System.out.println("Desea repetir el programa? 1=si 2=no");
    int condi = scanner.nextInt();
    if (condi == 1){

    }else {
condition=true;

    }

}

       



    }

public static void menu(){
Scanner scanner =new Scanner(System.in);
System.out.println("Digite el radio en centimetros");
double radio = scanner.nextDouble();
System.out.println("MENU");
System.out.println("1) Calcular area \n2) Calcular volumen");
int opcion = scanner.nextInt();


switch (opcion) {
    case 1:
    // metodo que calcule el area
        System.out.println("El area del circulo con radio "+radio+" es: "+calcular_area(radio)+"cm^2");
        break;
    case 2:
    //metodo que calcule el volumen
        System.out.println("El volumen de la esfera con radio "+radio+" es: "+calcular_volumen(radio)+"cm^3");
        break;
    default:
    System.out.println("Opcion no registrada");
        break;
}

}

public static double calcular_area(double ratio){

double areaCirculo = (Math.PI)*Math.pow(ratio,2);
return areaCirculo;
} 

public static double calcular_volumen(double ratio) {
    double volumenEsfera = (4/3)*(Math.PI)*Math.pow(ratio,3);
    

    return volumenEsfera;
}


}

