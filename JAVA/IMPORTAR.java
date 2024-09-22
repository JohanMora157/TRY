import java.util.Scanner;

public class IMPORTAR {
    public static void main(String[] args) {
        int nota, sumaNotas = 0;
        int numEs = 0;
        String[] students = {"juan", "camilo", "pedro", "luis", "johan", "david", "alejo"};
        Scanner scanner = new Scanner(System.in); // Mueve la declaración del scanner fuera del bucle

        for (int i = 0; i < students.length; i++) { // Cambia <= a <
            System.out.println("Ingrese la nota de " + students[i]);
            nota = Integer.parseInt(scanner.nextLine()); // Convierte la entrada a entero
            sumaNotas += nota; // Acumula las notas
            numEs++; // Incrementa el número de estudiantes
        }

        if (numEs > 0) {
            double promedio = (double) sumaNotas / numEs;
            System.out.println("El promedio de las notas es: " + promedio);
        } else {
            System.out.println("No se ingresaron notas.");
        }

        scanner.close(); // Cierra el scanner
    }
}
