import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;
public class ListasPro{
    public static void main (String[]args){
 Scanner scanner = new Scanner(System.in);
        HashMap <String, String> students = new HashMap<String, String>();
        HashMap <String, Integer> nameNotes = new HashMap<String, Integer>();
        //System.out.println("Digite el nombre del estidiante seguido de una coma(,) y luego el apellido ");
        for(int i=0;i<3;i++){
            System.out.println("Digite el nombre del estudiante");
            String names = scanner.nextLine();
            System.out.println("Digite el apellido del estudiante "+names);
            String Lnames = scanner.nextLine();
            
            students.put(names, Lnames);
        }
        //scanner.nextLine();

   // for(int a=0;a<students.size();a++){
        for(String mostrar:students.keySet()){
        System.out.println("Digite la nota del estudiante "+mostrar+" "+students.get(mostrar));
        int note = scanner.nextInt();
 nameNotes.put(mostrar+" "+students.get(mostrar), note);  
 }
   
//}
int maz=0;
//for(int f=0;f<nameNotes.size();f++){
    for(String r : nameNotes.keySet()){
    if(maz<nameNotes.get(r)){
        maz=nameNotes.get(r);

    }
}
//}
for(String b : nameNotes.keySet()){

    System.out.println("El estudiante "+b+" tiene como nota "+nameNotes.get(b));
    
    

}

System.out.println("La nota mas alta fue :"+maz);
    }
}