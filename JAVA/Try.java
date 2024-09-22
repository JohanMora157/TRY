import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.ArrayList;
public class Try{
    public static void main(String[]args){
        Scanner papi = new Scanner(System.in);  //Scanner
        ArrayList<String> lista = new ArrayList<String>();  //Array o lista

for(int i=0;i<3;i++){
  System.out.println("ingrese el nombre: ");
  String names =papi.nextLine();
  lista.add(names);

}

boolean x=true;
while(x==true){
  papi.nextLine();

System.out.println("que letra desea buscar en los nombres?");
String letra = papi.nextLine();

Pattern pattern = Pattern.compile(letra, Pattern.CASE_INSENSITIVE); // crear un Pattern + Pattern.compile(letra, Pattern tipo de busqueda)

//String oe = papi.nextLine();
for(int j=0;j<3;j++){


  Matcher matcher = pattern.matcher(lista.get(j)); // crear un matcher  + nombre del pattern.nombre del matcher(donde se va a bucar)
  boolean ola = matcher.find();// matcher.find(true si lo encuentra/false si no)
//System.out.println(ola);
if(ola){
    System.out.println(lista.get(j)+" contiene la letra "+letra);

}else {
    System.out.println(lista.get(j)+" no contiene la letra "+letra);
}

  }
System.out.println("desea buscar otra letra? 1==si 2==no");
int u =papi.nextInt();
if(u==1){


}else{
  x=false;
}

}
    











   /*       Pattern pattern = Pattern.compile("w3s-chools", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher("Visit W3S-chools!");
    boolean matchFound = matcher.find();
    if(matchFound) {
      System.out.println("Match found");
    } else {
      System.out.println("Match not found");
    }

*/

        
    }
  }