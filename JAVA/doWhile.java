
import java.util.Random;
import java.util.Scanner;
//import java.util.ArrayList;

public class doWhile {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        System.out.println("--BIENVENIDO A AKINATOR 500--");
        System.out.println("Presione ENTER para jugar!");
        scanner.nextLine();

//comienzo del juego
        System.out.println("INTENTE ADIVINAR UN NUMERO ENTRE [1-500]");
        int numRandom = random.nextInt(500) + 1;// genera numero de 1-500

        System.out.println("Su numero es:");
        int numPlayer = scanner.nextInt();

//evaluar si es mayor o menor 
//if (){
//}
    }
}
