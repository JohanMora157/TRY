import java.util.ArrayList;
import java.util.Scanner;




public class Rep {
public static void main(String[]args){
System.out.println("--LISTA DE ESTUDIANTES--");
Scanner scanner =new Scanner(System.in);
ArrayList <String> students = new ArrayList<String>();
int sum=1;
for(int i=0;i<3;i++){
System.out.println("digite el nombre del estudiante "+(sum+i));
String names = scanner.nextLine();
students.add(names);

}
System.out.println("--ESTUDIANTES INSCRITOS--");
for(String a : students){
    System.out.println(sum+"-"+a);
    sum++;
}
sum=1;
ArrayList<Integer> notes = new ArrayList<Integer>();
System.out.println("--APLICAR NOTAS AUTOMATICAMENTE [1] O MANUALMENTE [2]");
int a = scanner.nextInt();
if(a==1){
    for (int i=0;i<3;i++){
        notes.add((int) (Math.random()*6));

    }
    //for(int i=0;i<3;i++){
      //  System.out.println(sum+"-"+students.get(i)+" NOTA = "+notes.get(i));
        //sum++;

    //}
    

}else{
    boolean pas = true;
    for (int i=0;i<3;i++){
        pas=true;
        System.out.println("NOta del estudiante "+students.get(i));
while(pas==true){
    int c = scanner.nextInt();
        if(c<6 && c>0){
            notes.add(c);
            pas=false;

        }else{
            System.out.println("solo de 1-5");

        }
}
    }
  

    }
ArrayList<Integer> numWords = new ArrayList<Integer>();

for(int i=0;i<3;i++){
int numPala = students.get(i).split("\\s").length;
numWords.add(numPala);
}


for(int i=0;i<3;i++){
    System.out.println(sum+"-"+students.get(i)+" NOTA = "+notes.get(i)+" numero de palabras del nombre "+numWords.get(i));
    sum++;
}








}//final
}