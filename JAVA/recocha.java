import java.util.Scanner;
public class recocha{
    public static void main (String[]args){
    
        int nota, notas=0, promedios=0, numEs=0;
        String[] students ={"juan","camilo","pedro","luis","johan","david","alejo"};
        Scanner x = new Scanner(System.in);


        for (int i=0; i<students.length; i++){
System.out.println("Ingrese la nota de "+students[i]);
nota = Integer.parseInt(x.nextLine());
notas+=nota;
numEs++;

        }

        promedios=promedios+(notas/numEs);

        System.out.println("el promedio de todos los estudiantes fue de "+promedios);






    }

}