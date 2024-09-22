import java.util.Scanner;
import java.util.ArrayList;
public class PassOrNot{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> student = new ArrayList<String>();
        ArrayList<Integer> notes = new ArrayList<Integer>();

        System.err.println("Cuantos estudiantes?");
        int numStudents = scanner.nextInt();
    
        for(int i=0;i<numStudents;i++){
            scanner.nextLine();
            System.out.println("Digite el nombre del estudiante ["+i+"] ");
            String name = scanner.nextLine();
            student.add(name);

            System.out.println("Digite la nota del estudiante [0-5]: "+name.toUpperCase());
            int note = scanner.nextInt();
            if(note<=5 && note>0){
                notes.add(note);

            }else {
                while(note>5){
                    System.out.println("NOTA INVALIDA");
                    System.out.println("INGRESE OTRA NOTA [0-5]");
                    int noteNew = scanner.nextInt();
                    note = noteNew;

                }
                notes.add(note);
                

                
            }

           
        }

        for(int a=0;a<student.size();a++){
            System.out.println("estudiante ["+student.get(a)+"] con nota _"+notes.get(a)+"_"); 

        }
        System.out.println("QUE DESEA HACER?");
        System.out.println("[1]=Ver estudiantes que aprobaron [3-5]");
        System.out.println("[2]=Ver estudiantes que perdieron [0-2,99]");
        System.out.println("[3]=borrar todo");
        System.out.println("[4]=Estudiante con mejor nota");
        System.out.println("[5] PARA CERRAR");
        int options = scanner.nextInt();
        boolean f=true;
        while (f==true ) {
            
            switch (options) {
                case 1:

                if(student.size()==0){
                    System.out.println("NO HAY DATOS");
                }else {
                    System.out.println("ESTUDIANTES APROBADOS");

                for(int c=0;c<student.size();c++){
                   
                    if(notes.get(c)>=3){

                        
                        System.out.println("Estudiante "+student.get(c)+" con nota "+notes.get(c));

                    }

                }

                }
                
                    
                    break;
            
                case 2:
                
                if(student.size()==0){
                    System.out.println("NO HAY DATOS");
                }else {
                System.out.println("ESTUDIANTES REPROBADOS");
                for(int c=0;c<student.size();c++){
                if(notes.get(c)<3){

                   
                    System.out.println("Estudiante "+student.get(c)+" con nota "+notes.get(c));

                }}}
                    break;


                    case 3:
                    if(student.size()==0){
                        System.out.println("NO HAY DATOS");
                    }else {
                    student.clear();
                    notes.clear();
                    System.out.println("TODO HA SIDO BORRADO");
                    }
    
                    break;
                    
                    case 4:
                    if(student.size()==0){
                        System.out.println("NO HAY DATOS");
                    }else {
                    int max=0;
                    for(int d=0;d<student.size();d++){
                        if(max<notes.get(d)){

                            max=notes.get(d);
                        }
                    }
                    int posicion = notes.indexOf(max);

                    System.out.println("el estudiante "+student.get(posicion)+" con nota "+max+" es el mejor");
                }

                    break;

                    case 5:
                    f=false;
                    //f=true;

                    break;
            }
    System.out.println("DIGITE OTRO NUMERO PARA OTRA OPCION si quiere cerrar presione 5");
    int options2 = scanner.nextInt();
    if(options==5){
f=false;
    }else{
        options=options2;
    }
    
            
        }

        System.out.println("cerrado");

        



        








        
    }
}