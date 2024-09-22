import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class Listas{
        public static void main (String[]args){
            Scanner scanner = new Scanner(System.in);
            ArrayList<String> cars = new ArrayList<String>();
            cars.add("toyota");
            cars.add("renault");
            cars.add("Kia");
cars.add(0, "Mazda");
cars.set(2, "cambio");
cars.remove(0);
//cars.clear();  esto para borrar todo
            System.out.println(cars.get(2));
            //System.out.println(cars);
            for(String e:cars){
                System.out.println(e);
            }

            System.out.println(cars.size());//muestra cuantos objetos hay




ArrayList<String> students = new ArrayList<String>();
ArrayList<Integer> notes = new ArrayList<Integer>();

for(int i=0; i<5; i++){
    System.out.println("Ingrese el nombre del estudiante :"+(i+1));
    String save = scanner.nextLine();
    students.add(i, save);
    System.out.println("Ingrese la nota de :"+students.get(i));
    int note = scanner.nextInt();
    notes.add(i, note);
    
scanner.nextLine();
}
//Collections.sort(students);

for(int t=0;t<students.size();t++){
    System.out.println("La nota de "+students.get(t)+"es "+notes.get(t));

}

System.out.println("Desea cambiar alguna nota? 1=SI--2=NO");
int c = scanner.nextInt();
scanner.nextLine();
if(c==1){
System.out.println("Elija el estudiante"+students);
String choose = scanner.nextLine();
for(int y=0; y<students.size();y++){
    
    if(students.get(y).equals(choose)){

    System.out.println("Digite la nueva nota de "+students.get(y));
    int newnot = scanner.nextInt();
    notes.set(y, newnot);

    } else{
        
    }
}
scanner.nextLine();
for(int t=0;t<students.size();t++){
    System.out.println("La nota de "+students.get(t)+" es "+notes.get(t));
}
}






        }
}